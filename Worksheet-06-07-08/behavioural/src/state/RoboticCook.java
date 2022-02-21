package state;

import java.sql.SQLOutput;

public class RoboticCook implements RoboticState {
  Robot robby;
  public RoboticCook(Robot robot) {
    robby = robot;
  }

  @Override
  public void walk() {
    robby.setRoboticState(robby.getRoboticOn());
    robby.walk();
  }

  @Override
  public void cook() {
    System.out.println("Cooking...");
  }

  @Override
  public void off() {
    System.out.println("Cannot switch off at Cook state.");
  }
}
