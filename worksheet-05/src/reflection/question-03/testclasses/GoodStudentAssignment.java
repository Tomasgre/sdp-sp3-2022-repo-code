package reflection.question3.testclasses;

/**
 * Class that should pass every test in JUnit assignment test class.
 */
public class GoodStudentAssignment {

    public static void main(String[] args) { }

    private int a;
    private final int b = 3;
    private static final int d = -1;

    GoodStudentAssignment(){}

    GoodStudentAssignment(int a){  this.a = a; }

    public Integer GoodIntReturnType() { return 1; }
    public String GoodReturnType() { return "1"; }

    private static Integer helper1(){ return 10;}
    private static String helper2(){ return "helpful"; }
}