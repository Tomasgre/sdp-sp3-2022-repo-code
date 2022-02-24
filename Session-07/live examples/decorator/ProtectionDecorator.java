package decorator;

public class ProtectionDecorator extends Decorator {

    // rg is inherited from Decorator

    public ProtectionDecorator(ReportGenerator rg) {
        super(rg);
    }

    public boolean havePermission() {
        return true;
        // do something interesting here
    }

    @Override
    public String generateReport() {
        if (havePermission()) {
            return rg.generateReport();
        } else {
            return "Denied";
        }


    }
}
