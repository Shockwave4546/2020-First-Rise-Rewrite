package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;
import frc.robot.Constants.Tabs;
import frc.robot.utils.ShuffleboardSpeed;

public class Feeder extends MotoredSubsystem {
  private final MotorController feeder = new WPI_VictorSPX(Constants.Feeder.MOTOR_ID);
  private final ShuffleboardSpeed speed = new ShuffleboardSpeed(Tabs.SPEEDS, "Feeder Speed", Constants.Feeder.DEFAULT_SPEED);

  @Override public void run(double speed) {
    feeder.set(speed);
  }

  @Override public void run(boolean reversed) {
    feeder.set(speed.get() * (reversed ? -1 : 1));
  }

  @Override public void stop() {
    feeder.stopMotor();
  }
}