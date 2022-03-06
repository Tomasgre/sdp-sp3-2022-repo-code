package chain;

public class HandlerB extends Handler {

    public HandlerB(String name) {
        super(name);
    }

    @Override
    public void handle(String request) {
        if (request.equals("B"))
            System.out.println("Handler B does " + request);
        else {
            System.out.println("Handler B could not handle request " + request);
            super.handle(request);
        }
    }
}
