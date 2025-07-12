package web;

public class DatePickerActions {
    private final DatePickerView datePickerView;

    public DatePickerActions(DatePickerView datePickerView) {
        this.datePickerView = datePickerView;
    }

    public void enterDate(String date) {
        datePickerView.getInputDatePicker().clear();
        datePickerView.getInputDatePicker().sendKeys(date);
    }
}
