package web;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class CheckboxView {

    private final WebDriver driver;

    public CheckboxView(WebDriver driver) {
        this.driver = driver;
    }

    //Instead of using multiple web elements for each checkbox, we have implemented a method to get the checkbox by its number.
    public WebElement getCheckboxByNumber(int number) {
        return driver.findElement(By.xpath("//input[@id='checkbox-" + number + "']"));
    }

}
