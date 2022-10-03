import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //Class c1 = Class.forName("Person");
//        System.out.println(c1);
//        Integer i = 3;
//        System.out.println(i);
//        System.out.println(i.getClass());
//        Method[] meths = i.getClass().getDeclaredMethods();
//        //System.out.println(meths);
//
//        for (var m: meths){
//            System.out.println(m);
//        }
        var field = Person.class.getDeclaredFields();
        for (var m: field){
            System.out.println(m);
        }
        Class c1 = Class.forName("Person");
        var cons = c1.getClass().getConstructors();
        for (var c : cons){
            System.out.println(c);
        }
    }
}

class Person { // extends Object {
    private int x;
    protected float y;
    public boolean w;
    String s;
}