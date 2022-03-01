package template;

public abstract class Template {

    public void runProcess() {
        step1();
        step2();
        step3();
        step4();
    }

    public abstract void step1();
    public abstract void step2();
    public abstract void step3();
    public void step4() {
        System.out.println("Step 4: This step is common for all implementations.");
    }

}
