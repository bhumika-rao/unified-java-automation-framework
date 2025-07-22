package webTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;
import web.FileUploadActions;
import web.FileUploadView;

public class FileUploadTest extends BaseClass {
    private FileUploadView fileUploadView;
    private FileUploadActions fileUploadActions;

    {
        pageUrl = "/fileupload";
    }

    @BeforeClass
    public void setUp() {
        super.setUp();
        fileUploadView = new FileUploadView(driver);
        fileUploadActions = new FileUploadActions(driver, fileUploadView);
    }

    //Tests for image file upload functionality
    @Test
    public void testImageUpload() {
        // Verify file upload input is displayed
        Assert.assertTrue(fileUploadView.getInputFileUpload().isDisplayed(), "File upload input is not displayed.");

        fileUploadActions.uploadFile(ConfigReader.get("test.image.path"));

        // Verify the file was uploaded successfully
        Assert.assertTrue(fileUploadView.getInputFileUpload().getAttribute("value").contains(ConfigReader.get("test.image.path")), "Image file was not uploaded successfully.");
    }

    //Tests for video file upload functionality
    @Test
    public void testVideoUpload() {
        // Verify file upload input is displayed
        Assert.assertTrue(fileUploadView.getInputFileUpload().isDisplayed(), "File upload input is not displayed.");

        fileUploadActions.uploadFile(ConfigReader.get("test.video.path"));

        // Verify the file was uploaded successfully
        Assert.assertTrue(fileUploadView.getInputFileUpload().getAttribute("value").contains(ConfigReader.get("test.video.path")), "Video file was not uploaded successfully.");
    }
}
