package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class ButtonsActions extends BasePage {
    private final ButtonsView buttonsView;

    public ButtonsActions(WebDriver driver, ButtonsView buttonsView) {
        super(driver);
        this.buttonsView = buttonsView;
    }

    public boolean isPrimaryButtonDisplayed() {
        return buttonsView.getBtnPrimary().isDisplayed();
    }

    public boolean isSuccessButtonDisplayed() {
        return buttonsView.getBtnSuccess().isDisplayed();
    }

    public boolean isInfoButtonDisplayed() {
        return buttonsView.getBtnInfo().isDisplayed();
    }

    public boolean isWarningButtonDisplayed() {
        return buttonsView.getBtnWarning().isDisplayed();
    }

    public boolean isDangerButtonDisplayed() {
        return buttonsView.getBtnDanger().isDisplayed();
    }

    public boolean isLinkButtonDisplayed() {
        return buttonsView.getBtnLink().isDisplayed();
    }

    public void clickPrimaryButton() {
        buttonsView.getBtnPrimary().click();
    }

    public void clickSuccessButton() {
        buttonsView.getBtnSuccess().click();
    }

    public void clickInfoButton() {
        buttonsView.getBtnInfo().click();
    }

    public void clickWarningButton() {
        buttonsView.getBtnWarning().click();
    }

    public void clickDangerButton() {
        buttonsView.getBtnDanger().click();
    }

    public void clickLinkButton() {
        buttonsView.getBtnLink().click();
    }
}
