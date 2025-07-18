package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.SwitchWindowAndAlertActions;
import web.SwitchWindowAndAlertView;

import java.io.IOException;

public class SwitchWindowAndAlertTest extends BaseClass {

    private SwitchWindowAndAlertView switchWindowAndAlertView;
    private SwitchWindowAndAlertActions switchWindowAndAlertActions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "switch-window");
        switchWindowAndAlertView = new SwitchWindowAndAlertView(driver);
        switchWindowAndAlertActions = new SwitchWindowAndAlertActions(driver, switchWindowAndAlertView);
    }

    @Test
    public void testSwitchToNewWindow() {
        String title = switchWindowAndAlertActions.switchToNewWindowAndGetTitle();
        Assert.assertNotNull(title, "Failed to switch to new window.");
        System.out.println("New window title: " + title);
    }

    @Test
    public void testSwitchToAlert() {
        String alertText = switchWindowAndAlertActions.triggerAndAcceptAlert();
        Assert.assertEquals(alertText, "This is a test alert!", "Alert text mismatch.");
        System.out.println("Alert handled with text: " + alertText);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
