package decorator;

public class StylisedDecorator extends Decorator {

    public StylisedDecorator(ReportGenerator rg) {
        super(rg);
    }

    @Override
    public String generateReport() {
        return "Fancy stuff " + rg.generateReport();
    }
}
