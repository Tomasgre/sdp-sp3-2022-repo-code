package observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        System.out.println("Setting first data...\n");
        subject.setData("First data");
        System.out.println();

        System.out.println("Adding display observer and Setting second data...\n");
        subject.subscribe(new DisplayObserver());
        subject.setData("Second data");
        System.out.println();

        System.out.println("Adding Email observer and Setting third data...\n");
        subject.subscribe(new EmailObserver());
        subject.setData("Third data");
        System.out.println();

        System.out.println("Adding Logger observer and Setting fourth data...\n");
        subject.subscribe(new LoggerObserver());
        subject.setData("fourth data");


    }
}
