package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownView {

    private final WebDriver driver;

    public DropdownView(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getDropdownButton() {
        return driver.findElement(By.id("dropdownMenuButton"));
    }

    public By getDropdownOptionLocator(String optionText) {
        return By.xpath("//div[@class='dropdown-menu show']/a[text()='" + optionText + "']");
    }
}
