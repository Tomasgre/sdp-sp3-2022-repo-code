package decorator;

public class SchoolReportGenerator implements ReportGenerator {

    @Override
    public String generateReport() {
        return "School report";
    }
}
