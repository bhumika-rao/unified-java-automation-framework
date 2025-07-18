package web;

import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ModalView extends BasePage {
    @FindBy(id = "modal-button")
    private WebElement btnOpenModal;
    @FindBy(id = "close-button")
    private WebElement btnCloseModal;
    @FindBy(id = "ok-button")
    private WebElement btnOkModal;

    public ModalView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By getModalTitle() {
        return By.xpath("//*[text()='Modal title']");
    }

    public By getModalBody() {
        return By.cssSelector("body.modal-open");
    }
}
