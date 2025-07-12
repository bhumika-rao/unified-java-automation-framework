package webTests;

import base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.CheckboxActions;
import web.CheckboxView;

import java.io.IOException;

/**
 * This class contains tests for the Checkbox functionality on the web application.
 * It demonstrates the use of TestNG's dependsOnMethod functionality
 */

public class CheckboxTest extends BaseClass {

    private CheckboxView checkboxView;
    private CheckboxActions checkboxActions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "checkbox");

        checkboxView = new CheckboxView(driver);
        checkboxActions = new CheckboxActions(checkboxView);
    }

    @Test
    public void testSelectionOfCheckboxes() {
        // Check the first checkbox
        checkboxActions.selectCheckbox(1);
        // Verify the first checkbox is checked
        checkboxActions.isCheckboxSelected(1);

        // Check the second checkbox
        checkboxActions.selectCheckbox(2);
        // Verify the second checkbox is checked
        checkboxActions.isCheckboxSelected(2);

        // Check the third checkbox
        checkboxActions.selectCheckbox(3);
        // Verify the third checkbox is checked
        checkboxActions.isCheckboxSelected(3);
    }

    @Test(dependsOnMethods = "testSelectionOfCheckboxes")
    public void testUnselectionOfCheckboxes() {
        // Uncheck the first checkbox
        checkboxActions.unSelectCheckbox(1);
        // Verify the first checkbox is unchecked
        checkboxActions.isCheckboxUnselected(1);

        // Uncheck the second checkbox
        checkboxActions.unSelectCheckbox(2);
        // Verify the second checkbox is unchecked
        checkboxActions.isCheckboxUnselected(2);

        // Uncheck the third checkbox
        checkboxActions.unSelectCheckbox(3);
        // Verify the third checkbox is unchecked
        checkboxActions.isCheckboxUnselected(3);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
