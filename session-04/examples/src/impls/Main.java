package impls;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var loader = Main.class.getClassLoader();
        Arrays.stream(loader.getDefinedPackages()).forEach(System.out::println);
        //Arrays.stream(loader.getParent().getDefinedPackages()).forEach(System.out::println);
    }
}
