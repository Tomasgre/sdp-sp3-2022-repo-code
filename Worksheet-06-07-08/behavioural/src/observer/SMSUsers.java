package observer;

public class SMSUsers implements Observer {

    Subject subject;
    String user;

    public SMSUsers(Subject subject, String s) {
        this.subject = subject;
        user = s;
    }

    @Override
    public void update(String desc) {
        System.out.println(user + " " + desc);
    }

    @Override
    public void subscribe() {
        System.out.println("Subscribing " + user + " to " + subject.subjectDetails());
        subject.subscribeObserver(this);
    }

    @Override
    public void unSubscribe() {
        System.out.println("Unsubscribing " + user + " from " + subject.subjectDetails());
        subject.unSubscribeObserver(this);
    }
}
