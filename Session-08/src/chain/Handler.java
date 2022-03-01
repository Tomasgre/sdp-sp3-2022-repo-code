package chain;

public class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler h) {
        nextHandler = h;
    }

    // Override
    public void handle(String request) {
        if (nextHandler != null)
            nextHandler.handle(request);
        else
            System.out.println("Could not handle request: " + request);
    }
}
