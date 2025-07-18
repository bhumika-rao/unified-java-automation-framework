package web;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class DatePickerView {

    @FindBy(xpath = "//input[@id='datepicker']")
    private WebElement inputDatePicker;

    public DatePickerView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
