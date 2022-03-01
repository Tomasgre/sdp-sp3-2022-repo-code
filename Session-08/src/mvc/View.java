package mvc;

public class View {
    public Model model;
    public Controller controller;

    public String message = "";

    public void init() {
        System.out.println("Initially, the bit has value " + model.getValue());
    }

    public void refresh() {
        System.out.println(message);
        System.out.println("The bit has value " + model.getValue());
    }

    public void clickedTrue() {
        controller.setValue(true);
    }

    public void clickedFalse() {
        controller.setValue(false);
    }

    public void warnUnnecessaryUpdate() {
        message = "Warning: Unnecessary update.";
    }

    public void successfulUpdate() {
        message = "Value successfully changed.";
    }
}
