package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.ButtonsActions;
import web.ButtonsView;

import java.io.IOException;

/**
 * Test class for all button types on Formy Buttons page.
 * Uses Page Object Model (View + Actions) and TestNG.
 * Verifies presence and click functionality of:
 * - Primary
 * - Success
 * - Info
 * - Warning
 * - Danger
 * - Link buttons
 */

public class ButtonsTest extends BaseClass {

    private ButtonsView buttonsView;
    private ButtonsActions buttonsActions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "buttons");

        buttonsView = new ButtonsView(driver);
        buttonsActions = new ButtonsActions(buttonsView);
    }


    @Test
    public void testPrimaryButton() {
        Assert.assertTrue(buttonsActions.isPrimaryButtonDisplayed(), "Primary button is not displayed.");
        buttonsActions.clickPrimaryButton();
    }

    @Test
    public void testSuccessButton() {
        Assert.assertTrue(buttonsActions.isSuccessButtonDisplayed(), "Success button is not displayed.");
        buttonsActions.clickSuccessButton();
    }

    @Test
    public void testInfoButton() {
        Assert.assertTrue(buttonsActions.isInfoButtonDisplayed(), "Info button is not displayed.");
        buttonsActions.clickInfoButton();
    }

    @Test
    public void testWarningButton() {
        Assert.assertTrue(buttonsActions.isWarningButtonDisplayed(), "Warning button is not displayed.");
        buttonsActions.clickWarningButton();
    }

    @Test
    public void testDangerButton() {
        Assert.assertTrue(buttonsActions.isDangerButtonDisplayed(), "Danger button is not displayed.");
        buttonsActions.clickDangerButton();
    }

    @Test
    public void testLinkButton() {
        Assert.assertTrue(buttonsActions.isLinkButtonDisplayed(), "Link button is not displayed.");
        buttonsActions.clickLinkButton();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
