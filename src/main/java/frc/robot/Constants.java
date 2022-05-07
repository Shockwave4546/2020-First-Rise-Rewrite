package frc.robot;

public class Constants {
  public static class Controller {
    public static final int DRIVE_PORT = 0;
    public static final int OPERATOR_PORT = 1;
  }

  /**
   * The drivetrain's motor controllers are all PWM.
   */
  public static class Drivetrain {
    public static final int FRONT_LEFT_MOTOR_CHANNEL = 0; // Motor Controller 1 - Red
    public static final int BACK_LEFT_MOTOR_CHANNEL = 1; // Motor Controller 2 - Red
    public static final int FRONT_RIGHT_MOTOR_CHANNEL = 2; // Motor Controller 3 - Red w/ stripes
    public static final int BACK_RIGHT_MOTOR_CHANNEL = 3; // Motor Controller 3 - Red w/ stripes
  }
  
  public static class Feeder {
    
  }

  public static class FortuneWheel {
    public static final int MOTOR_ID = 10; // Motor Controller 5 - Yellow
  }

  public static final class Intake {
    public static final int MOTOR_ID = 11; // Motor Controller 6 - Green
  }

  public static final class IntakePivot {
    public static final int MOTOR_ID = 12; // Motor Controller 6 - Green
  }



  public static class Flywheel {

  }
}