package singleton;

public class SingletonLazy {

    private String message = "Lazy";

    private static SingletonLazy obj = null;

    // private constructor
    private SingletonLazy() {}

    public static SingletonLazy getInstance()
    {
        if (obj == null)
            obj = new SingletonLazy();
        return obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
