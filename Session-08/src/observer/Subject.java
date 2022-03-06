package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String data = "";
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void remove(Observer o) {
        observers.remove(o);
    }

    public void notifyAll(String params) {
        for (Observer o : observers)
            o.notify(params);
    }

    public void setData(String newData) {
        if (!this.data.equals(newData)) {
            data = newData;
            System.out.println("Data changed -- notifying observers");
            notifyAll("Data changed to: " + newData);
        }
    }
}
