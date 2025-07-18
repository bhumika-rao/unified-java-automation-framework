package web;

import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SwitchWindowAndAlertView extends BasePage {

    @FindBy(id = "new-tab-button")
    public WebElement btnNewTab;
    @FindBy(id = "alert-button")
    public WebElement btnAlert;

    public SwitchWindowAndAlertView(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
