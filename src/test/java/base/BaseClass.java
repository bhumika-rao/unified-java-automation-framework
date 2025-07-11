package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static final String webAutomationUrl = "https://formy-project.herokuapp.com/";
    protected WebDriver driver;
    protected DriverFactory driverFactory;
    protected Properties config;

    @BeforeMethod
    public void setUp() throws IOException {
        config = new Properties();
        FileInputStream fis = new FileInputStream("resources/config.properties");
        config.load(fis);

        driverFactory = new DriverFactory(config);
        driver = driverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverFactory.quitDriver();
    }
}
