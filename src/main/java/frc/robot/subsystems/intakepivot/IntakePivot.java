package frc.robot.subsystems.intakepivot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;
import frc.robot.Constants.Tabs;
import frc.robot.subsystems.MotoredSubsystem;
import frc.robot.utils.ShuffleboardSpeed;

public class IntakePivot extends MotoredSubsystem {
  private final MotorController intakePivot = new WPI_VictorSPX(Constants.IntakePivot.MOTOR_ID);
  private final DigitalInput topLimitSwitch = new DigitalInput(Constants.DIO.TOP_SWITCH);
  private final DigitalInput bottomLimitSwitch = new DigitalInput(Constants.DIO.BOTTOM_SWITCH);
  private final ShuffleboardSpeed speed = new ShuffleboardSpeed(Tabs.SPEEDS, "Intake Pivot Speed", Constants.IntakePivot.DEFAULT_SPEED);

  public IntakePivot() {
    Tabs.DEBUG.add("Top Limit Switch", topLimitSwitch);
    Tabs.DEBUG.add("Bottom Limit Switch", bottomLimitSwitch);
  }

  @Override public void run(double speed) {
    intakePivot.set(speed);
  }

  @Override public void run(boolean reversed) {
    intakePivot.set(speed.get() * (reversed ? -1 : 1));
  }

  @Override public void stop() {
    intakePivot.stopMotor();
  }

  public boolean topSwitch() {
    return !topLimitSwitch.get();
  }

  public boolean bottomSwitch() {
    return !bottomLimitSwitch.get();
  }
}