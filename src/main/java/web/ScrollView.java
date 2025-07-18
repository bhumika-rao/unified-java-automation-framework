package web;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ScrollView {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "date")
    private WebElement dateField;

    public ScrollView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
