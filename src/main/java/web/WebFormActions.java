package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebFormActions extends BasePage {

    private final WebFormView webFormView;

    public WebFormActions(WebDriver driver, WebFormView webFormView) {
        super(driver);
        this.webFormView = webFormView;
    }

    public void enterFirstName(String firstName) {
        webFormView.getInputFirstName().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        webFormView.getInputLastName().sendKeys(lastName);
    }

    public void enterJobTitle(String jobTitle) {
        webFormView.getInputJobTitle().sendKeys(jobTitle);
    }

    public void selectLevelOfEducation(String education) {
        switch (education.toLowerCase()) {
            case "high school":
                webFormView.getRadioBtnHighSchool().click();
                break;
            case "college":
                webFormView.getRadioBtnCollege().click();
                break;
            case "grad school":
                webFormView.getRadioBtnGradSchool().click();
                break;
            default:
                throw new IllegalArgumentException("Invalid education level: " + education);
        }
    }

    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                webFormView.getCheckBoxMale().click();
                break;
            case "female":
                webFormView.getCheckBoxFemale().click();
                break;
            case "prefer not to say":
                webFormView.getCheckBoxPreferNotToSay().click();
                break;
            default:
                throw new IllegalArgumentException("Invalid input: " + gender);
        }
    }

    public void selectExperienceByVisibleText(String visibleText) {
        Select dropdown = new Select(webFormView.getDropdownYearsOfExperience());
        dropdown.selectByVisibleText(visibleText);
    }

    public void enterDate(String date) {
        webFormView.getInputDatePicker().sendKeys(date);
    }

    public void submitForm() {
        webFormView.getBtnSubmit().click();
    }

    public String getSuccessMessage() {
        return webFormView.getSuccessMessage().getText();
    }
}
