package chain;

public class HandlerB extends Handler {

    @Override
    public void handle(String request) {
        if (request.equals("B"))
            System.out.println("Handler B does " + request);
        else {
            System.out.println("Handler B could not handle request " + request + ", passing on");
            super.handle(request);
        }
    }
}
