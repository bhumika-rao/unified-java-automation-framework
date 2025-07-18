package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.WebFormActions;
import web.WebFormView;

import java.io.IOException;

public class WebFormTest extends BaseClass {

    private WebFormActions webFormActions;
    private WebFormView webFormView;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "form");
        webFormView = new WebFormView(driver);
        webFormActions = new WebFormActions(driver, webFormView);
    }

    @Test
    public void testFillWebForm() {
        webFormActions.enterFirstName("John");
        webFormActions.enterLastName("Doe");
        webFormActions.enterJobTitle("Software Engineer");
        webFormActions.selectLevelOfEducation("College");
        webFormActions.selectGender("Male");
        webFormActions.selectExperienceByVisibleText("2-4");
        webFormActions.enterDate("10-01-2023");
        webFormActions.submitForm();
        Assert.assertEquals(
                webFormActions.getSuccessMessage().trim(),
                "The form was successfully submitted!",
                "Form submission failed or success message not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
