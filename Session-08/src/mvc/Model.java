package mvc;

public class Model {
    public View view;

    private Boolean value = false;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean newValue) {
        this.value = newValue;
        view.updateMessage();
    }
}
