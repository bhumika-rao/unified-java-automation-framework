package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.ButtonsActions;
import web.ButtonsView;

import java.io.IOException;

public class ButtonsTest extends BaseClass {

    // This class will contain tests for the Buttons functionality
    // It will use the ButtonsView and ButtonsActions classes to interact with the web elements

    @BeforeMethod
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "buttons");
    }

    @Test
    public void testPrimaryButton() {
        ButtonsView buttonsView = new ButtonsView(driver);
        ButtonsActions buttonsActions = new ButtonsActions(buttonsView);
        Assert.assertTrue(buttonsActions.isPrimaryButtonDisplayed(), "Primary button is not displayed.");
        buttonsActions.clickPrimaryButton();
        // Add assertions to verify the expected behavior
    }
}
