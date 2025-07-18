package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindowAndAlertActions extends BasePage {

    private final SwitchWindowAndAlertView switchWindowAndAlertView;

    public SwitchWindowAndAlertActions(WebDriver driver, SwitchWindowAndAlertView switchWindowAndAlertView) {
        super(driver);
        this.switchWindowAndAlertView = switchWindowAndAlertView;
    }

    public String switchToNewWindowAndGetTitle() {
        String parentWindow = driver.getWindowHandle();
        switchWindowAndAlertView.getBtnNewTab().click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                String newTitle = driver.getTitle();
                driver.close();
                driver.switchTo().window(parentWindow);
                return newTitle;
            }
        }
        return null;
    }

    public String triggerAndAcceptAlert() {
        switchWindowAndAlertView.getBtnAlert().click();
        seleniumUtils.waitForAlert();

        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }
}
