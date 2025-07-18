package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final SeleniumUtils seleniumUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int timeout = 10; // 10 seconds default timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        seleniumUtils = new SeleniumUtils(driver, 10);
    }
}
