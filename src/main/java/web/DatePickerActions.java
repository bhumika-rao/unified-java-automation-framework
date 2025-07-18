package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class DatePickerActions extends BasePage {
    private final DatePickerView datePickerView;

    public DatePickerActions(WebDriver driver, DatePickerView datePickerView) {
        super(driver);
        this.datePickerView = datePickerView;
    }

    public void enterDate(String date) {
        datePickerView.getInputDatePicker().clear();
        datePickerView.getInputDatePicker().sendKeys(date);
    }
}
