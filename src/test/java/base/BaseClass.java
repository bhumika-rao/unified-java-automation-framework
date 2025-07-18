package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {

    protected static String webAutomationUrl;
    protected static Properties config = new Properties(); // static
    protected String pageUrl;
    protected WebDriver driver;
    protected DriverFactory driverFactory;

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("config.properties not found");
            }
            config.load(input);
        }
        webAutomationUrl = config.getProperty("baseUrl");
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        if (config == null) {
            throw new RuntimeException("Config was not initialized!");
        }
        this.pageUrl = pageUrl;
        driverFactory = new DriverFactory(config);
        driver = driverFactory.initDriver();
        driver.get(webAutomationUrl + this.pageUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
