package singleton;

import java.io.Serializable;

public class SingletonProtected implements Serializable {

    /*
    There are many ways to break the singleton pattern. One is in a multi-threaded environment but others include:

        If the class is Serializable.
        If it is Cloneable.
        It can be broken by reflection.
        If the class is loaded by multiple class loaders.

     */

    // volatile means that the object isn't cached and taken direct from memory
    private static volatile SingletonProtected obj = null;
    // fields must be transient as part of efforts to avoid serializability
    private transient String message = "Protected";

    private SingletonProtected() {
    }

    public static synchronized SingletonProtected getInstance() {
        if (obj == null) {
            obj = new SingletonProtected();
        }
        return obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // to prevent a Singleton from being cloned - should it extend a parent class
    // that does implement Cloneable
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // to prevent a Singleton from being serialized - Create a readResolve() method
    // This method is used in the deserialization process
    protected Object readResolve() {
        return getInstance();
    }
}
