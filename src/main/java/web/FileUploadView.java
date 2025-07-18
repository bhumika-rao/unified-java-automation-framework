package web;

import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FileUploadView extends BasePage {

    @FindBy(id = "file-upload-field")
    private WebElement inputFileUpload;
    @FindBy(xpath = "//button[contains(text(),'Choose')]")
    private WebElement btnFileChoose;
    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElement btnFileReset;

    public FileUploadView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
