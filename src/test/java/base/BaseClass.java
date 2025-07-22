package base;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Properties;

@Getter
public class BaseClass {

    protected static String webAutomationUrl;
    protected static Properties config = new Properties(); // static
    protected String pageUrl;
    protected WebDriver driver;
    protected DriverFactory driverFactory;

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() throws IOException {
        webAutomationUrl = ConfigReader.get("baseUrl");
    }

    @BeforeClass(alwaysRun = true)
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

