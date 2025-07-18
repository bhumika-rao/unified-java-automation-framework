package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class ScrollActions extends BasePage {
    private final ScrollView scrollView;

    public ScrollActions(WebDriver driver, ScrollView scrollView) {
        super(driver);
        this.scrollView = scrollView;
    }

    public boolean scrollAndValidateNameFieldIsVisible() {
        seleniumUtils.scrollToElement(scrollView.getNameField());
        return seleniumUtils.isElementInView(scrollView.getNameField());
    }

    public boolean scrollAndValidateDateFieldIsVisible() {
        seleniumUtils.scrollToElement(scrollView.getDateField());
        return seleniumUtils.isElementInView(scrollView.getDateField());
    }

    public void enterName(String name) {
        seleniumUtils.scrollToElement(scrollView.getNameField());
        scrollView.getNameField().sendKeys(name);
    }

    public void enterDate(String name) {
        seleniumUtils.scrollToElement(scrollView.getDateField());
        scrollView.getDateField().sendKeys(name);
    }
}
