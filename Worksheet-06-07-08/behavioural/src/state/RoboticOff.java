package state;

public class RoboticOff implements RoboticState {
  Robot robby;
  public RoboticOff(Robot robot) {
    robby = robot;
  }

  @Override
  public void walk() {
    robby.setRoboticState(robby.getRoboticOn());
    robby.walk();
  }

  @Override
  public void cook() {
    System.out.println("Cannot cook at Off state.");
  }

  @Override
  public void off() {
    System.out.println("Robot is switched off");
  }
}
