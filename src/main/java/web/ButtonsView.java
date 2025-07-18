package web;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ButtonsView {

    @FindBy(xpath = "//button[contains(text(),'Primary')]")
    private WebElement btnPrimary;

    @FindBy(xpath = "//button[contains(text(),'Success')]")
    private WebElement btnSuccess;

    @FindBy(xpath = "//button[contains(text(),'Info')]")
    private WebElement btnInfo;

    @FindBy(xpath = "//button[contains(text(),'Warning')]")
    private WebElement btnWarning;

    @FindBy(xpath = "//button[contains(text(),'Danger')]")
    private WebElement btnDanger;

    @FindBy(xpath = "//button[contains(text(),'Link')]")
    private WebElement btnLink;

    public ButtonsView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
