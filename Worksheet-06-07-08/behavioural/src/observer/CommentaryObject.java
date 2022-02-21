package observer;

import java.util.List;

public class CommentaryObject implements Subject, Commentary {

  List<Observer> observers;
  String description;
  String subjectDetails;

  public CommentaryObject(List<Observer> observers, String s) {
    this.observers = observers;
    this.subjectDetails = s;
  }

  @Override
  public void setDesc(String desc) {
    this.description = desc;
    notifyObservers();
  }

  @Override
  public void subscribeObserver(Observer observer) {
    this.observers.add(observer);
    System.out.println("Subscribed successfully.");
  }

  @Override
  public void unSubscribeObserver(Observer observer) {
    this.observers.remove(observer);
    System.out.println("Unsubscribed successfully.");
  }

  @Override
  public void notifyObservers() {
    for (Observer ob: this.observers) {
      ob.update(this.description);
    }
  }

  @Override
  public String subjectDetails() {
    return this.subjectDetails;
  }
}
