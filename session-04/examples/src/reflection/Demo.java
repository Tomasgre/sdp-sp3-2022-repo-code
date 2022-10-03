package reflection;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        System.out.println(new Object().getClass());
//        var meths = new Object().getClass().getMethods();
//        for (var m: meths){
//            System.out.println(m);
//        }
//      System.out.println(Arrays.toString(meths));
//      Arrays.stream(meths).forEach(System.out::println);
    }
}
