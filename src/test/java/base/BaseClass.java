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
    protected String pageUrl;

    protected WebDriver driver;
    protected DriverFactory driverFactory;
    protected Properties config;

    @BeforeSuite
    public void loadConfig() throws IOException {
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("config.properties not found");
            }
            config.load(input);
        }
        webAutomationUrl = config.getProperty("baseUrl");
    }


    @BeforeClass
    public void setUp() {
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
