package mediator;

public class Heater implements Colleague {
  private MachineMediator mediator;

  @Override
  public void setMediator(MachineMediator mediator) {
    this.mediator = mediator;
  }

  public void on(int setting) {
    System.out.println("Heater is on...");
    System.out.println("Temperature is set to " + setting);

    if (mediator.checkTemperature(setting)) {
      mediator.off();
    }
  }

  public void off() {
    System.out.println("Heater is off...");
    mediator.wash();
  }
}
