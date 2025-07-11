package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties config;

    public DriverFactory(Properties properties) {
        config = properties;
    }

    public WebDriver initDriver() {
        String browser = config.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);
        switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", config.getProperty("chrome.driver.path"));
                ChromeOptions options = new ChromeOptions();
                if ("true".equals(config.getProperty("headless"))) {
                    options.addArguments("--headless=new");
                }
                driver.set(new ChromeDriver(options));
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", config.getProperty("firefox.driver.path"));
                driver.set(new FirefoxDriver());
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(config.getProperty("implicit.wait", "10"))));
        return driver.get();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
