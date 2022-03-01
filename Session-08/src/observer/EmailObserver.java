package observer;

public class EmailObserver implements Observer {

    @Override
    public void notify(String params) {
        System.out.println("Sending email notification for event: " + params);
    }
}