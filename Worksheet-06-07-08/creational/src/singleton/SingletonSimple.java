package singleton;

public class SingletonSimple {

    // EAGER initiation via a static field which is instantiated when the class is initialized
    public static final SingletonSimple obj = new SingletonSimple();
    private String message = "Static field instantiation";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
