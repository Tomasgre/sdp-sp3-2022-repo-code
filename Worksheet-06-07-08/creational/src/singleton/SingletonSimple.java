package singleton;

public class SingletonSimple {

    private String message = "Static field instantiation";

    // EAGER initiation via a static field which is instantiated when the class is initialized
    public static final SingletonSimple obj = new SingletonSimple();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
