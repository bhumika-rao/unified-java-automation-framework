package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.DragDropActions;
import web.DragDropView;

import java.io.IOException;

/**
 * Test class for Drag and Drop functionality.
 * This class tests the drag and drop feature by dragging an image to a target box
 * and verifying that the image is dropped successfully.
 * Though drag and drop is not a automated testable feature in Selenium,
 * we have implemented a solution to demonstrate testing of it.
 */
public class DragDropTest extends BaseClass {

    private DragDropView view;
    private DragDropActions actions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "dragdrop");

        view = new DragDropView(driver);
        actions = new DragDropActions(driver, view);
    }

    @Test
    public void testDragAndDropImage() {
        actions.performDragAndDrop();

        // Validation: Check if the image is still visible in the drop box
        Assert.assertTrue(view.getTargetBox().getText().contains("Dropped!"),
                "Image not dropped successfully.");
    }
}
