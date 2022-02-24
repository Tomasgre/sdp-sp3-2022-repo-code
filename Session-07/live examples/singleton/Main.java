package singleton;

public class Main {
    public static void main(String[] args) {

        Singleton s = Singleton.getInstance();

        System.out.println(s.getMessage());
        s.setMessage("Another message");
        System.out.println(s.getMessage());

        Singleton s2 = Singleton.getInstance();
        assert s == s2;

    }
}
