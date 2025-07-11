package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int timeout = 10; // seconds, you can parametrize if you want
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    protected void typeText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }
}
