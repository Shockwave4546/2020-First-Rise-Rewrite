package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class Constants {
  public static class Tabs {
    public static final ShuffleboardTab SPEEDS = Shuffleboard.getTab("Speeds");
    public static final ShuffleboardTab DEBUG = Shuffleboard.getTab("Debug");
  }

  public static class ControllerPort {
    public static final int DRIVE = 0;
    public static final int OPERATOR = 1;
  }

  /**
   * The drivetrain's motor controllers are all PWM.
   */
  public static class Drivetrain {
    public static final int FRONT_LEFT_MOTOR_CHANNEL = 0; // Motor Controller 1 - Red
    public static final int BACK_LEFT_MOTOR_CHANNEL = 1; // Motor Controller 2 - Red
    public static final int FRONT_RIGHT_MOTOR_CHANNEL = 2; // Motor Controller 3 - Red w/ stripes
    public static final int BACK_RIGHT_MOTOR_CHANNEL = 3; // Motor Controller 3 - Red w/ stripes
    public static final double LEFT_SPEED_MULTIPLIER = 1.0;
    public static final double RIGHT_SPEED_MULTIPLIER = 1.0;
  }

  public static class FortuneWheel {
    public static final int MOTOR_ID = 10; // Motor Controller 5 - Yellow
  }

  public static final class Intake {
    public static final int MOTOR_ID = 11; // Motor Controller 6 - Green
    public static final double DEFAULT_SPEED = 0.75;
  }

  public static final class IntakePivot {
    public static final int MOTOR_ID = 12; // Motor Controller 6 - Green
    public static final double DEFAULT_SPEED = 0.3;
  }

  public static class Flywheel {
    public static final int MOTOR_ID_ONE = 13;
    public static final int MOTOR_ID_TWO = 14;
    public static final double DEFAULT_SPEED = 0.6;
  }

  public static class Feeder {
    public static final int MOTOR_ID = 15;
    public static final double DEFAULT_SPEED = 0.3;
  }

  public static class DIO {
    public static final int TOP_SWITCH = 2;
    public static final int BOTTOM_SWITCH = 3;
  }
}