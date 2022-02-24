package decorator;

public abstract class Decorator implements ReportGenerator {

    protected ReportGenerator rg;

    public Decorator(ReportGenerator rg) {
        this.rg = rg;
    }

    abstract public String generateReport();
}
