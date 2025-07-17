package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumUtils;

public class DropdownActions {

    private final DropdownView dropdownView;
    private final WebDriver driver;
    SeleniumUtils seleniumUtils;

    public DropdownActions(WebDriver driver, DropdownView dropdownView) {
        this.driver = driver;
        this.dropdownView = dropdownView;
        seleniumUtils = new SeleniumUtils(driver, 10);
    }

    public void selectDropdownOptionWithWait(String optionText) {
        dropdownView.getDropdownButton().click();
        By optionLocator = dropdownView.getDropdownOptionLocator(optionText);
        seleniumUtils.waitForClickability(optionLocator); // Wait until the option is clickable
        seleniumUtils.safeClick(optionLocator);
    }


    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}
