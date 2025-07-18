package web;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class DragDropView {

    @FindBy(id = "image")
    private WebElement sourceImage;

    @FindBy(id = "box")
    private WebElement targetBox;

    public DragDropView(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
