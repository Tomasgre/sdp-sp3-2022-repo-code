package singleton;

public class SingletonLazy2 {

    private String message = "Lazy nested";

    public static SingletonLazy2 getInstance() {
        return SingletonLazy2.ResourceHolder.instance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // can use a nested class to achieve lazy initialization as nested classes aren't
    // initialized at the same time as the outer class
    private static class ResourceHolder {
        static final SingletonLazy2 instance = new SingletonLazy2();
    }
}
