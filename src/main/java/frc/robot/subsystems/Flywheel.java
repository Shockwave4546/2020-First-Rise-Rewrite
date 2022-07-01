package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;
import frc.robot.utils.ShuffleboardSpeed;

public class Flywheel extends MotoredSubsystem {
  private final MotorController flywheelOne = new WPI_VictorSPX(Constants.Flywheel.MOTOR_ID_ONE);
  private final MotorController flywheelTwo = new WPI_VictorSPX(Constants.Flywheel.MOTOR_ID_TWO);
  private final MotorControllerGroup flywheel = new MotorControllerGroup(flywheelOne, flywheelTwo);
  private final ShuffleboardSpeed speed;
  
  public Flywheel(ShuffleboardTab tab) {
    speed = new ShuffleboardSpeed(tab, "Flywheel Speed", Constants.Flywheel.DEFAULT_SPEED);
  }

  @Override public void run(double speed) {
    flywheel.set(speed); 
  }

  @Override public void run() {
    flywheel.set(speed.get());
  }

  @Override public void stop() {
    flywheel.stopMotor();
  }
}