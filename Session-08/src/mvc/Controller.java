package mvc;

public class Controller {
    Model model;
    View view;

    public void setValue(Boolean newValue) {
        if (model.getValue().equals(newValue))
            view.warnUnnecessaryUpdate();
        else {
            model.setValue(newValue);
            view.successfulUpdate();
        }
        view.refresh();
    }
}
