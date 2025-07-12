package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropActions {

    private final WebDriver driver;
    private final DragDropView view;

    public DragDropActions(WebDriver driver, DragDropView view) {
        this.driver = driver;
        this.view = view;
    }

    public void performDragAndDrop() {
        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(view.getSourceImage(), view.getTargetBox())
                .build()
                .perform();
    }
}
