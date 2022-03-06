package singleton;

public class Client {

    public static void main(String[] args) {

        Singleton s = Singleton.getInstance();
        System.out.println(s.getMessage());
        // if obj field is public can access it directly and don't need getInstance methods.
        // Singleton s2 = Singleton.obj;
        Singleton s2 = Singleton.getInstance();
        s2.setMessage("Static message changed");
        System.out.println(s.getMessage());
        if (s.equals(s2)) {
            System.out.println("Same Singleton instance!");
        }

        System.out.println("-----------------------------");

        SingletonSimple sb = SingletonSimple.obj;
        System.out.println(sb.getMessage());
        SingletonSimple sb2 = SingletonSimple.obj;
        if (sb.equals(sb2)) {
            System.out.println("Same Simple Singleton instance!");
        }

        System.out.println("-----------------------------");

        SingletonLazy sl = SingletonLazy.getInstance();
        System.out.println(sl.getMessage());
        SingletonLazy sl2 = SingletonLazy.getInstance();
        sl2.setMessage("Lazy message changed");
        System.out.println(sl.getMessage());
        if (sl.equals(sl2)) {
            System.out.println("Same Lazy Singleton instance!");
        }

        System.out.println("-----------------------------");

        SingletonLazy2 sla = SingletonLazy2.getInstance();
        System.out.println(sla.getMessage());
        SingletonLazy2 sla2 = SingletonLazy2.getInstance();
        sla2.setMessage("Lazy message changed");
        System.out.println(sla.getMessage());
        if (sla.equals(sla2)) {
            System.out.println("Same Lazy Nested Singleton instance!");
        }

        System.out.println("-----------------------------");

        SingletonProtected slp = SingletonProtected.getInstance();
        System.out.println(slp.getMessage());
        SingletonProtected slp2 = SingletonProtected.getInstance();
        slp2.setMessage("Protected message changed");
        System.out.println(slp.getMessage());
        if (slp.equals(slp2)) {
            System.out.println("Same Protected Singleton instance!");
        }

    }
}
