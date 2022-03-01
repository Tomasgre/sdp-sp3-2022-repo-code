package observer;

public class DisplayObserver implements Observer {
    @Override
    public void notify(String params) {
        System.out.println("Displaying event on screen: " + params);
    }
}
