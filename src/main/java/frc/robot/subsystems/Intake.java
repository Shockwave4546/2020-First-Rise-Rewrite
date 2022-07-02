package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;
import frc.robot.Constants.Tabs;
import frc.robot.utils.ShuffleboardSpeed;

public class Intake extends MotoredSubsystem {
  private final MotorController intake = new WPI_VictorSPX(Constants.Intake.MOTOR_ID);
  private final ShuffleboardSpeed speed = new ShuffleboardSpeed(Tabs.SPEEDS, "Intake Speed", Constants.Intake.DEFAULT_SPEED);

  @Override public void run(double speed) {
    intake.set(speed);
  }

  @Override public void run(boolean reversed) {
    intake.set(speed.get() * (reversed ? -1 : 1));
  }

  @Override public void stop() {
    intake.stopMotor();
  }
}