package reflection.question3.testclasses;

import java.util.ArrayList;

/**
 * Class that should fail every test in JUnit assignment test class.
 */
public class BadStudentAssignment {
    public static void main(String[] args) { }

    private ArrayList<Integer> failingArrayListField = new ArrayList<>();
    private int a;
    private final int b = 3;
    public int failingPublicField = 1;
    private static final int d = -1;

    BadStudentAssignment(int a){  this.a = a; }

    public int BadReturnType() { return 1; }
    public Integer GoodIntReturnType() { return 1; }
    public String GoodReturnType() { return "1"; }
    public void BadThrows() throws Exception { throw new Exception(); }

    private static Integer helper1(){ return 10;}
}