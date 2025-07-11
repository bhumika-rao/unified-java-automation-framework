package web;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ButtonsView {

    @FindBy(xpath = "//button[contains(text(),'Primary')]")
    public WebElement btnPrimary;
    @FindBy(xpath = "//button[contains(text(),'Success')]")
    public WebElement btnSuccess;
    @FindBy(xpath = "//button[contains(text(),'Info')]")
    public WebElement btnInfo;
    @FindBy(xpath = "//button[contains(text(),'Warning')]")
    public WebElement btnWarning;
    @FindBy(xpath = "//button[contains(text(),'Danger')]")
    public WebElement btnDanger;
    @FindBy(xpath = "//button[contains(text(),'Link')]")
    public WebElement btnLink;

    public ButtonsView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
