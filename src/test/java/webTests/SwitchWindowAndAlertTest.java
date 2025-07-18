package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.SwitchWindowAndAlertActions;
import web.SwitchWindowAndAlertView;

public class SwitchWindowAndAlertTest extends BaseClass {

    private SwitchWindowAndAlertView switchWindowAndAlertView;
    private SwitchWindowAndAlertActions switchWindowAndAlertActions;

    {
        pageUrl = "/switch-window";
    }

    @BeforeClass
    public void setUp() {
        super.setUp();
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
}
