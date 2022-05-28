package diydi;

public class Main {
    public static void main(String[] args) {
        TextService tc = new TextClassFactory().getTextClass();
        System.out.println(tc.doSomethingElseWithText("Hello"));
        System.out.println(tc.doSomethingWithText("Goodbye"));
    }
}
