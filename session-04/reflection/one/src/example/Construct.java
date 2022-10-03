package example;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Construct {
    public static void main(String[] args) {
        Class c;
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.print("The name of the class: ");
            var aclass = sc.next();
            c = Class.forName(aclass);
            var constructors = c.getConstructor(null);
//            for (var cons : constructors){
//                System.out.println(cons.getParameterCount());
//            }
            var obj = constructors.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not find the class");
        } catch (InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }

    @Override
    public String toString(){
        return "XXXXX";
    }
}
