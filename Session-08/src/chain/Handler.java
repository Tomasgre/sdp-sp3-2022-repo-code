package chain;

public class Handler {
    protected String name;
    protected Handler nextHandler;

    public Handler(String name) {
        this.name = name;
    }

    public void setNextHandler(Handler h) {
        nextHandler = h;
    }

    // Override
    // Default implementation: pass request to next handler immediately
    public void handle(String request) {
        if (nextHandler != null) {
            System.out.println("Passing request to next handler, " + nextHandler.name);
            nextHandler.handle(request);
        }
        else
            System.out.println("No handler for request: " + request);
    }
}
