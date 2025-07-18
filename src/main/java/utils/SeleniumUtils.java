package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public SeleniumUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        this.js = (JavascriptExecutor) driver;
    }

    // Wait until element is visible
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until element is present in DOM
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Scroll to element
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    // Click using JavaScript
    public void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    // Wait until text is present in element
    public void waitForText(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Combined: Wait-Scroll-Click
    public void waitScrollClick(By locator) {
        WebElement element = waitForClickability(locator);
        scrollToElement(element);
        element.click();
    }

    public void typeText(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text after visibility
    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    // Check if element is displayed (with wait)
    public boolean isElementDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Safe click (JS fallback if normal click fails)
    public void safeClick(By locator) {
        try {
            WebElement element = waitForClickability(locator);
            scrollToElement(element);
            element.click();
        } catch (ElementClickInterceptedException | TimeoutException e) {
            WebElement element = driver.findElement(locator);
            jsClick(element);
        }
    }

    // Scroll to bottom of page
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll to top of page
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    // Wait for attribute value
    public void waitForAttribute(By locator, String attribute, String value) {
        wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
    }

    // Wait for element to disappear
    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Get attribute value safely
    public String getAttribute(By locator, String attr) {
        return waitForPresence(locator).getAttribute(attr);
    }

    // Highlight element (for debug / screenshots)
    public void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // Clear field and send keys
    public void clearAndType(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        js.executeScript("arguments[0].value='';", element);
        element.sendKeys(text);
    }

    public boolean isElementInView(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Object result = jsExecutor.executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                        "return (" +
                        "rect.top >= 0 && " +
                        "rect.left >= 0 && " +
                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
                element
        );

        return result instanceof Boolean && (Boolean) result;
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}



