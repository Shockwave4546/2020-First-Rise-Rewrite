package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.api.shuffleboard.AdjustableSpeed;

public class Drivetrain extends SubsystemBase {
  private final MotorController frontLeft = new Talon(Constants.Drivetrain.FRONT_LEFT_MOTOR_CHANNEL);
  private final MotorController frontRight = new Talon(Constants.Drivetrain.FRONT_RIGHT_MOTOR_CHANNEL);
  private final MotorController backLeft = new Talon(Constants.Drivetrain.BACK_LEFT_MOTOR_CHANNEL);
  private final MotorController backRight = new Talon(Constants.Drivetrain.BACK_RIGHT_MOTOR_CHANNEL);
  private final MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeft, backLeft);
  private final MotorControllerGroup rightGroup = new MotorControllerGroup(frontRight, backRight);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftGroup, rightGroup);
  private final AdjustableSpeed leftSpeedMultiplier;
  private final AdjustableSpeed rightSpeedMultiplier;
  private final XboxController controller;

  public Drivetrain(ShuffleboardTab speedsTab, XboxController controller) {
    leftSpeedMultiplier = new AdjustableSpeed(speedsTab, "Left Speed Multiplier", Constants.Drivetrain.LEFT_SPEED_MULTIPLIER);
    rightSpeedMultiplier = new AdjustableSpeed(speedsTab, "Right Speed Multiplier", Constants.Drivetrain.RIGHT_SPEED_MULTIPLIER);
    this.controller = controller;
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