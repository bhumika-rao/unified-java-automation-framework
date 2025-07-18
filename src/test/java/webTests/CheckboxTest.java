package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.CheckboxActions;
import web.CheckboxView;

/**
 * This class contains tests for the Checkbox functionality on the web application.
 * It demonstrates the use of TestNG's dependsOnMethod functionality
 */

public class CheckboxTest extends BaseClass {

    private CheckboxView checkboxView;
    private CheckboxActions checkboxActions;

    {
        pageUrl = "/checkbox";
    }

    @BeforeClass
    public void setUp() {
        super.setUp();
        checkboxView = new CheckboxView(driver);
        checkboxActions = new CheckboxActions(driver, checkboxView);
    }

    @Test
    public void testSelectionOfCheckboxes() {
        // Check the first checkbox
        checkboxActions.selectCheckbox(1);
        // Assert it is selected
        Assert.assertTrue(checkboxActions.isCheckboxSelected(1), "Checkbox 1 should be selected");

        // Check the second checkbox
        checkboxActions.selectCheckbox(2);
        Assert.assertTrue(checkboxActions.isCheckboxSelected(2), "Checkbox 2 should be selected");

        // Check the third checkbox
        checkboxActions.selectCheckbox(3);
        Assert.assertTrue(checkboxActions.isCheckboxSelected(3), "Checkbox 3 should be selected");
    }

    @Test(dependsOnMethods = "testSelectionOfCheckboxes")
    public void testUnselectionOfCheckboxes() {
        // Uncheck the first checkbox
        checkboxActions.unSelectCheckbox(1);
        Assert.assertFalse(checkboxActions.isCheckboxSelected(1), "Checkbox 1 should be unselected");

        // Uncheck the second checkbox
        checkboxActions.unSelectCheckbox(2);
        Assert.assertFalse(checkboxActions.isCheckboxSelected(2), "Checkbox 2 should be unselected");

        // Uncheck the third checkbox
        checkboxActions.unSelectCheckbox(3);
        Assert.assertFalse(checkboxActions.isCheckboxSelected(3), "Checkbox 3 should be unselected");
    }
}
