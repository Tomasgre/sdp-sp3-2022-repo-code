package observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        System.out.println("Setting first data...");
        subject.setData("First data");
        System.out.println();

        System.out.println("Adding display observer and Setting second data...");
        subject.subscribe(new DisplayObserver());
        subject.setData("Second data");
        System.out.println();

        System.out.println("Adding Email observer and Setting third data...");
        subject.subscribe(new EmailObserver());
        subject.setData("Third data");
        System.out.println();

        System.out.println("Adding Logger observer and Setting fourth data...");
        subject.subscribe(new LoggerObserver());
        subject.setData("fourth data");


    }
}
