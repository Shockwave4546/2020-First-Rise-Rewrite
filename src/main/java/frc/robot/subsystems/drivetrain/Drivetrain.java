package frc.robot.subsystems.drivetrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Tabs;
import frc.robot.utils.ShuffleboardSpeed;

public class Drivetrain extends SubsystemBase {
  private final MotorControllerGroup leftGroup = new MotorControllerGroup(
    new Talon(Constants.Drivetrain.FRONT_LEFT_MOTOR_CHANNEL), 
    new Talon(Constants.Drivetrain.BACK_LEFT_MOTOR_CHANNEL)
  );
  private final MotorControllerGroup rightGroup = new MotorControllerGroup(
    new Talon(Constants.Drivetrain.FRONT_RIGHT_MOTOR_CHANNEL), 
    new Talon(Constants.Drivetrain.BACK_RIGHT_MOTOR_CHANNEL)
  );
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftGroup, rightGroup);
  private final ShuffleboardSpeed leftSpeedMultiplier = new ShuffleboardSpeed(Tabs.SPEEDS, "Left Speed Multiplier", Constants.Drivetrain.LEFT_SPEED_MULTIPLIER);
  private final ShuffleboardSpeed rightSpeedMultiplier = new ShuffleboardSpeed(Tabs.SPEEDS, "Right Speed Multiplier", Constants.Drivetrain.RIGHT_SPEED_MULTIPLIER);
  private final AHRS gyro = new AHRS();
  private final XboxController controller;

  public Drivetrain(XboxController controller) {
    this.controller = controller;
    Tabs.DEBUG.add(gyro);
    diffDrive.setSafetyEnabled(false);
    rightGroup.setInverted(true);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed * leftSpeedMultiplier.get(), rightSpeed * rightSpeedMultiplier.get());
  }

  public void stop() {
    diffDrive.stopMotor();
  }

  public void initTeleop() {
    setDefaultCommand(new TeleopTankDrive(controller, this));
  }
}