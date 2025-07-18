package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.ModalActions;
import web.ModalView;

public class ModalTest extends BaseClass {

    private ModalView modalView;
    private ModalActions modalActions;

    {
        pageUrl = "/modal";
    }

    @BeforeClass
    public void setUp() {
        super.setUp();
        modalView = new ModalView(driver);
        modalActions = new ModalActions(driver, modalView);
    }

    @Test
    public void testOpenModal() {
        // Open the modal
        modalActions.openModal();

        // Verify the modal is open
        Assert.assertTrue(modalActions.waitForModalOpen(), "Modal did not open successfully");

        // Verify the modal title
        String expectedTitle = "Modal title";
        String actualTitle = modalActions.getModalTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Modal title is incorrect");

    }

    @Test(dependsOnMethods = "testOpenModal")
    public void testCloseModal() {
        // Close the modal
        modalActions.closeModal();

        // Verify the modal is closed
        Assert.assertTrue(modalActions.waitForModalClosed(), "Modal did not close successfully");
    }
}
