package web;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalActions extends BasePage {

    private final ModalView modalView;

    public ModalActions(WebDriver driver, ModalView modalView) {
        super(driver);
        this.modalView = modalView;
    }

    public void openModal() {
        modalView.getBtnOpenModal().click();
        seleniumUtils.waitForVisibility(modalView.getModalTitle());
    }

    public void closeModal() {
        modalView.getBtnCloseModal().click();
        seleniumUtils.waitForInvisibility(modalView.getModalBody());
    }

    public void clickOk() {
        modalView.getBtnOkModal().click();
    }

    public String getModalTitle() {
        seleniumUtils.waitForVisibility(modalView.getModalTitle());
        return driver.findElement(modalView.getModalTitle()).getText();
    }

    public boolean waitForModalOpen() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(driver -> driver.findElement(By.tagName("body"))
                            .getAttribute("class").contains("modal-open"));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForModalClosed() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(driver -> !driver.findElement(By.tagName("body"))
                            .getAttribute("class").contains("modal-open"));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
