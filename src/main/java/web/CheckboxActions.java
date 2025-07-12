package web;

public class CheckboxActions {

    private final CheckboxView checkboxView;

    public CheckboxActions(CheckboxView checkboxView) {
        this.checkboxView = checkboxView;
    }

    public void selectCheckbox(int number) {
        if (!checkboxView.getCheckboxByNumber(number).isSelected()) {
            checkboxView.getCheckboxByNumber(number).click();
        }
    }

    public boolean isCheckboxSelected(int number) {
        return checkboxView.getCheckboxByNumber(number).isSelected();
    }

    public void unSelectCheckbox(int number) {
        if (checkboxView.getCheckboxByNumber(number).isSelected()) {
            checkboxView.getCheckboxByNumber(number).click();
        }
    }

    public boolean isCheckboxUnselected(int number) {
        return !checkboxView.getCheckboxByNumber(number).isSelected();
    }
}
