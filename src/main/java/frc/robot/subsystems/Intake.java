package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;
import frc.robot.utils.ShuffleboardSpeed;

public class Intake extends MotoredSubsystem {
  private final MotorController intake = new WPI_VictorSPX(Constants.Intake.MOTOR_ID);
  private final ShuffleboardSpeed speed;

  public Intake(ShuffleboardTab tab) {
    speed = new ShuffleboardSpeed(tab, "Intake speed", Constants.Intake.DEFAULT_SPEED);
  }

  @Override public void run(double speed) {
    intake.set(speed);
  }

  @Override public void run() {
    intake.set(speed.get());
  }

  @Override public void stop() {
    intake.stopMotor();
  }
}