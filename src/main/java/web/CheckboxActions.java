package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckboxActions extends BasePage {

    private final CheckboxView checkboxView;

    public CheckboxActions(WebDriver driver, CheckboxView checkboxView) {
        super(driver);
        this.checkboxView = checkboxView;
    }

    public void selectCheckbox(int number) {
        if (!checkboxView.getCheckboxByNumber(number).isSelected()) {
            checkboxView.getCheckboxByNumber(number).click();
        }
    }

    public boolean isCheckboxSelected(int number) {
        return checkboxView.getCheckboxByNumber(number).isSelected();
    }

    public void unSelectCheckbox(int number) {
        if (checkboxView.getCheckboxByNumber(number).isSelected()) {
            checkboxView.getCheckboxByNumber(number).click();
        }
    }

    public boolean isCheckboxUnselected(int number) {
        return !checkboxView.getCheckboxByNumber(number).isSelected();
    }
}
