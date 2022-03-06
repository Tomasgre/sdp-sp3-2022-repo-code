package observer;

public class LoggerObserver implements Observer {

    @Override
    public void notify(String params) {
        System.out.println("Writing event to log: " + params);
    }
}
