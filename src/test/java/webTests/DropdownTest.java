package webTests;

import base.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.DropdownActions;
import web.DropdownView;

public class DropdownTest extends BaseClass {

    private DropdownActions dropdownActions;
    private DropdownView dropdownView;

    {
        pageUrl = "/dropdown";
    }

    @BeforeClass
    public void setUp() {
        super.setUp();
        dropdownView = new DropdownView(driver);
        dropdownActions = new DropdownActions(driver, dropdownView);
    }

    @Test
    public void testAllDropdownOptionsUsingSoftAssert() {
        SoftAssert softAssert = new SoftAssert();

        String[][] dropdownOptions = {
                {"Autocomplete", "https://formy-project.herokuapp.com/autocomplete"},
                {"Buttons", "https://formy-project.herokuapp.com/buttons"},
                {"Checkbox", "https://formy-project.herokuapp.com/checkbox"},
                {"Datepicker", "https://formy-project.herokuapp.com/datepicker"},
                {"Drag and Drop", "https://formy-project.herokuapp.com/dragdrop"},
                {"Enabled and disabled elements", "https://formy-project.herokuapp.com/enabled"},
                {"File Upload", "https://formy-project.herokuapp.com/fileupload"},
                {"Key and Mouse Press", "https://formy-project.herokuapp.com/keypress"},
                {"Modal", "https://formy-project.herokuapp.com/modal"},
                {"Page Scroll", "https://formy-project.herokuapp.com/scroll"},
                {"Radio Button", "https://formy-project.herokuapp.com/radiobutton"},
                {"Switch Window", "https://formy-project.herokuapp.com/switch-window"},
                {"Complete Web Form", "https://formy-project.herokuapp.com/form"},
                {"Dropdown", "https://formy-project.herokuapp.com/dropdown"} // tests reload as well
        };

        for (String[] option : dropdownOptions) {
            String optionText = option[0];
            String expectedUrl = option[1];

            dropdownActions.selectDropdownOptionWithWait(optionText);
            String actualUrl = dropdownActions.getCurrentPageUrl();

            softAssert.assertEquals(actualUrl, expectedUrl,
                    "Navigation failed for: " + optionText);
        }

        softAssert.assertAll();
    }
}
