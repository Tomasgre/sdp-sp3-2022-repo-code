package mvc;

public class Controller {
    Model model;
    View view;

    public void setValue(Boolean newValue) {
        if (model.getValue().equals(newValue))
            // model is not updated
            view.setStatusWarning(); // note that the View is responsible for the exact message, etc.
        else {
            model.setValue(newValue);
            view.setStatusSuccess();
        }
    }
}
