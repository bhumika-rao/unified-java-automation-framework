package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class FileUploadActions extends BasePage {

    private final FileUploadView fileUploadView;

    public FileUploadActions(WebDriver driver, FileUploadView fileUploadView) {
        super(driver);
        this.fileUploadView = fileUploadView;
    }

    public void uploadFile(String filePath) {
        fileUploadView.getInputFileUpload().sendKeys(filePath);
    }

    public void clickUpload() {
        fileUploadView.getBtnFileChoose().click();
    }
}
