package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utils.ShuffleboardSpeed;

public class Drivetrain extends SubsystemBase {
  private final MotorController frontLeft = new Talon(Constants.Drivetrain.FRONT_LEFT_MOTOR_CHANNEL);
  private final MotorController frontRight = new Talon(Constants.Drivetrain.FRONT_RIGHT_MOTOR_CHANNEL);
  private final MotorController backLeft = new Talon(Constants.Drivetrain.BACK_LEFT_MOTOR_CHANNEL);
  private final MotorController backRight = new Talon(Constants.Drivetrain.BACK_RIGHT_MOTOR_CHANNEL);
  private final MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeft, backLeft);
  private final MotorControllerGroup rightGroup = new MotorControllerGroup(frontRight, backRight);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftGroup, rightGroup);
  private final ShuffleboardSpeed leftSpeedMultiplier;
  private final ShuffleboardSpeed rightSpeedMultiplier;
  private final XboxController controller;

  public Drivetrain(ShuffleboardTab speedsTab, XboxController controller) {
    leftSpeedMultiplier = new ShuffleboardSpeed(speedsTab, "Left Speed Multiplier", Constants.Drivetrain.LEFT_SPEED_MULTIPLIER);
    rightSpeedMultiplier = new ShuffleboardSpeed(speedsTab, "Right Speed Multiplier", Constants.Drivetrain.RIGHT_SPEED_MULTIPLIER);
    this.controller = controller;
    rightGroup.setInverted(true);
  }

  // I highly doubt this will drive straight, since the original code negates both values, but that's just a workaround, so fix it later in the room
  // https://github.com/Shockwave4546/FIRST-RISE-2020/blob/8900aaa993e7b314ffd21e47cc9d92fa330bef7c/src/main/java/frc/robot/Robot.java#L156
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