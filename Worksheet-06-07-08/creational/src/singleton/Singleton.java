package singleton;

public class Singleton {

    // EAGER initiation via a static field which is instantiated when the class is initialized
    private static final Singleton obj = new Singleton();
    private String message = "Static field instantiation";

    public static Singleton getInstance() {
        return obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
