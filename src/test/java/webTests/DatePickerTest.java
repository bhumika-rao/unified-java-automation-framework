package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.DatePickerActions;
import web.DatePickerView;

import java.io.IOException;

/**
 * Test class for the DatePicker functionality on the Formy DatePicker page.
 * Uses Page Object Model (View + Actions) and TestNG DataProvider.
 * Demonstrates the use of DataProvider for parameterized tests.
 * Verifies date entry functionality for various dates.
 */
public class DatePickerTest extends BaseClass {
    private DatePickerView datePickerView;
    private DatePickerActions datePickerActions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "datepicker");

        datePickerView = new DatePickerView(driver);
        datePickerActions = new DatePickerActions(driver, datePickerView);
    }

    @DataProvider(name = "dateProvider")
    public Object[][] getDateData() {
        return new Object[][]{
                {"01/01/1900"}, //First date in the 20th century
                {"06/03/1967"},
                {"09/09/1973"},
                {"26/04/1992"},
                {"22/02/1998"},
                {"02/29/2024"}, // Leap year
                {"31/12/2030"}  //Last date in 2030
        };
    }

    @Test(dataProvider = "dateProvider")
    public void testDateEntry(String date) {
        datePickerActions.enterDate(date);
        Assert.assertEquals(datePickerView.getInputDatePicker().getAttribute("value"), date, "Date not entered correctly");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
