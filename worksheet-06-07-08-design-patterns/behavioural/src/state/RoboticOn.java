package state;

public class RoboticOn implements RoboticState {
    Robot robby;

    public RoboticOn(Robot robot) {
        robby = robot;
    }

    @Override
    public void walk() {
        System.out.println("Walking...");
    }

    @Override
    public void cook() {
        robby.setRoboticState(robby.getRoboticCook());
        robby.cook();
    }

    @Override
    public void off() {
        robby.setRoboticState(robby.getRoboticOff());
        robby.off();
    }
}
