package web;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownActions extends BasePage {

    private final DropdownView dropdownView;

    public DropdownActions(WebDriver driver, DropdownView dropdownView) {
        super(driver);
        this.dropdownView = dropdownView;
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
