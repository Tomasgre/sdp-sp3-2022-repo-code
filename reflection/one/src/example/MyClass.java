package example;

public class MyClass {
    private String a;
    private String b;

    public MyClass(String a, String b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return "a = " + a + " and b = " + b;
    }
}
