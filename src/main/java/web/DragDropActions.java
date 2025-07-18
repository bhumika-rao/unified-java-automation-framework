package web;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropActions extends BasePage {

    private final DragDropView view;

    public DragDropActions(WebDriver driver, DragDropView view) {
        super(driver);
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
