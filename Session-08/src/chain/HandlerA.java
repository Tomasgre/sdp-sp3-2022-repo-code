package chain;

public class HandlerA extends Handler {

    @Override
    public void handle(String request) {
        if (request.equals("A"))
            System.out.println("Handler A does " + request);
        else {
            System.out.println("Handler A could not handle request " + request + ", passing on");
            super.handle(request);
        }
    }
}
