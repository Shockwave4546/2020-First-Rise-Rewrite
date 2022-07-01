package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utils.ShuffleboardSpeed;

public class IntakePivot extends MotoredSubsystem {
  private final MotorController intakePivot = new WPI_VictorSPX(Constants.IntakePivot.MOTOR_ID);
  private final ShuffleboardSpeed speed;

  public IntakePivot(ShuffleboardTab tab) {
    speed = new ShuffleboardSpeed(tab, "Intake Pivot Speed", Constants.IntakePivot.MOTOR_ID);
  }

  @Override public void run(double speed) {
    intakePivot.set(speed);
  }

  @Override public void run() {
    intakePivot.set(speed.get());
  }

  @Override public void stop() {
    intakePivot.stopMotor();
  }
}