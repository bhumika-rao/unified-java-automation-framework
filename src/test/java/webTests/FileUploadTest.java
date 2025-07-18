package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.FileUploadActions;
import web.FileUploadView;

import java.io.IOException;

public class FileUploadTest extends BaseClass {
    private FileUploadView fileUploadView;
    private FileUploadActions fileUploadActions;

    @BeforeClass
    public void setUp() throws IOException {
        super.setUp();
        driver.get(webAutomationUrl + "fileupload");
        fileUploadView = new FileUploadView(driver);
        fileUploadActions = new FileUploadActions(driver, fileUploadView);
    }

    //Tests for image file upload functionality
    @Test
    public void testImageUpload() {
        // Verify file upload input is displayed
        Assert.assertTrue(fileUploadView.getInputFileUpload().isDisplayed(), "File upload input is not displayed.");

        fileUploadActions.uploadFile(config.getProperty("test.image.path"));

        // Verify the file was uploaded successfully
        Assert.assertTrue(fileUploadView.getInputFileUpload().getAttribute("value").contains(config.getProperty("test.image.path")), "Image file was not uploaded successfully.");
    }

    //Tests for video file upload functionality
    @Test
    public void testVideoUpload() {
        // Verify file upload input is displayed
        Assert.assertTrue(fileUploadView.getInputFileUpload().isDisplayed(), "File upload input is not displayed.");

        fileUploadActions.uploadFile(config.getProperty("test.video.path"));

        // Verify the file was uploaded successfully
        Assert.assertTrue(fileUploadView.getInputFileUpload().getAttribute("value").contains(config.getProperty("test.video.path")), "Video file was not uploaded successfully.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
