package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.ScrollActions;
import web.ScrollView;

import java.io.IOException;

public class ScrollTest extends BaseClass {
    private ScrollView scrollView;
    private ScrollActions scrollActions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "scroll");
        scrollView = new ScrollView(driver);
        scrollActions = new ScrollActions(driver, scrollView);
    }

    @Test
    public void testScrollToNameAndDateField() {
        Assert.assertTrue(scrollActions.scrollAndValidateNameFieldIsVisible(), "Name field is not visible after scroll");
        Assert.assertTrue(scrollActions.scrollAndValidateDateFieldIsVisible(), "Date field is not visible after scroll");
    }


    @Test
    public void testEnterNameAndDate() {
        // Enter name and date after scrolling
        scrollActions.enterName("Jane Doe");
        scrollActions.enterDate("2023-10-01");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
