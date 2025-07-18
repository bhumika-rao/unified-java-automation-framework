package web;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class WebFormView {

    @FindBy(id = "first-name")
    private WebElement inputFirstName;

    @FindBy(id = "last-name")
    private WebElement inputLastName;

    @FindBy(id = "job-title")
    private WebElement inputJobTitle;

    @FindBy(xpath = "//input[following-sibling::text()[contains(.,'High School')]]")
    private WebElement radioBtnHighSchool;

    @FindBy(xpath = "//input[following-sibling::text()[contains(.,'College')]]")
    private WebElement radioBtnCollege;

    @FindBy(xpath = "//input[following-sibling::text()[contains(.,'Grad School')]]")
    private WebElement radioBtnGradSchool;

    @FindBy(xpath = "//input[following-sibling::text()[contains(.,'Male')]]")
    private WebElement checkBoxMale;

    @FindBy(xpath = "//input[following-sibling::text()[contains(.,'Female')]]")
    private WebElement checkBoxFemale;

    @FindBy(xpath = "//input[following-sibling::text()[contains(.,'Prefer not to say')]]")
    private WebElement checkBoxPreferNotToSay;

    @FindBy(id = "datepicker")
    private WebElement inputDatePicker;

    @FindBy(id = "select-menu")
    private WebElement dropdownYearsOfExperience;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//div[contains(text(),'The form was successfully submitted!')]")
    private WebElement successMessage;

    public WebFormView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
