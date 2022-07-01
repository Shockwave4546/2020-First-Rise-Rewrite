package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants.ControllerPort;
import frc.robot.controller.ShockwaveController;
import frc.robot.subsystems.drivetrain.Drivetrain;

public class RobotContainer {
  private final ShuffleboardTab speedsTab = Shuffleboard.getTab("Speeds");
  private final ShockwaveController driveController = new ShockwaveController(ControllerPort.DRIVE);
  private final ShockwaveController operatorController = new ShockwaveController(ControllerPort.OPERATOR);
  protected final Drivetrain drivetrain = new Drivetrain(speedsTab, driveController);

  public RobotContainer() {

  }
}