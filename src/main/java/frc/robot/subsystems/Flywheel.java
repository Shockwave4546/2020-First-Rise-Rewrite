package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;
import frc.robot.Constants.Tabs;
import frc.robot.utils.ShuffleboardSpeed;

public class Flywheel extends MotoredSubsystem {
  private final MotorController flywheelOne = new WPI_VictorSPX(Constants.Flywheel.MOTOR_ID_ONE);
  private final MotorController flywheelTwo = new WPI_VictorSPX(Constants.Flywheel.MOTOR_ID_TWO);
  private final MotorControllerGroup flywheel = new MotorControllerGroup(flywheelOne, flywheelTwo);
  private final ShuffleboardSpeed speed = new ShuffleboardSpeed(Tabs.SPEEDS, "Flywheel Speed", Constants.Flywheel.DEFAULT_SPEED);

  @Override public void run(double speed) {
    flywheel.set(speed); 
  }

  @Override public void run(boolean reversed) {
    flywheel.set(speed.get() * (reversed ? -1 : 1));
  }

  @Override public void stop() {
    flywheel.stopMotor();
  }
}