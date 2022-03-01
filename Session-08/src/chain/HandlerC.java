package chain;

public class HandlerC extends Handler {

    @Override
    public void handle(String request) {
        if (request.equals("C"))
            System.out.println("Handler C does " + request);
        else
            System.out.println("Handler C could not handle request " + request + " and rejects it!");
            // does not try to do any further handling
    }
}
