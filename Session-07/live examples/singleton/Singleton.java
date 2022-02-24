package singleton;

public class Singleton {

    private String message;

    // Eager initialisation
    private static final Singleton instance = new Singleton();

    private Singleton() {
        message = null;
    }

    public static Singleton getInstance() {
        return instance;
    }



    public String getMessage() {
        return this.message;
    }

    public void setMessage(String s) {
        this.message = s;
    }

}
