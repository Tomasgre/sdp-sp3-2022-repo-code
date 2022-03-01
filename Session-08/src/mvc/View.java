package mvc;

public class View {
    public Model model;
    public Controller controller;

    public String status;
    public String message;

    public void init() {
        status = "Successfully initialised.";
        updateMessage();
    }

    public void render() {
        System.out.println(status);
        System.out.println(message);
    }

    public void updateMessage() {
        message = "The bit has value: " + model.getValue();
    }

    public void clickedTrue() {
        controller.setValue(true);
    }
    public void clickedFalse() {
        controller.setValue(false);
    }

    public void setStatusWarning() {
        status = "Warning: Unnecessary update.";
    }
    public void setStatusSuccess() {
        status = "Value successfully changed.";
    }
}
