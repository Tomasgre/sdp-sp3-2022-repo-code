package decorator;

public class CommercialReportGenerator implements ReportGenerator {

    @Override
    public String generateReport() {
        return "Commercial report";
    }
}
