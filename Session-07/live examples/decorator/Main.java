package decorator;

public class Main {
    public static void main(String[] args) {

        ReportGenerator plainRG = new CommercialReportGenerator();

        ReportGenerator protectedRG = new ProtectionDecorator(plainRG);

        ReportGenerator stylisedAndProtectedRG = new StylisedDecorator(protectedRG);

        ReportGenerator stylisedRG = new StylisedDecorator(plainRG);

        ReportGenerator veryStylisedRG =
                new StylisedDecorator(
                        new StylisedDecorator(
                                new StylisedDecorator(plainRG)
                            )
                );

        plainRG.generateReport();
        protectedRG.generateReport();
        stylisedRG.generateReport();
        stylisedAndProtectedRG.generateReport();
        veryStylisedRG.generateReport();

    }
}
