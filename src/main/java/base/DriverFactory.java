package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final Properties config;

    public DriverFactory(Properties properties) {
        this.config = properties;
    }

    public WebDriver initDriver() {
        String browser = ConfigReader.get("browser").toLowerCase(Locale.ROOT);
        WebDriver localDriver;

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if ("true".equals(ConfigReader.get("headless"))) {
                    options.addArguments("--headless=new");
                }
                localDriver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                localDriver = new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(ConfigReader.get("implicit.wait")))
        );

        driver.set(localDriver);
        return localDriver;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }
}
