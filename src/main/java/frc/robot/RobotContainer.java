package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants.ControllerPort;
import frc.robot.controller.ShockwaveController;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakePivot;
import frc.robot.subsystems.drivetrain.Drivetrain;

public class RobotContainer {
  private final ShuffleboardTab speedsTab = Shuffleboard.getTab("Speeds");
  private final ShockwaveController driveController = new ShockwaveController(ControllerPort.DRIVE);
  private final ShockwaveController operatorController = new ShockwaveController(ControllerPort.OPERATOR);
  protected final Drivetrain drivetrain = new Drivetrain(speedsTab, driveController);
  private final Feeder feeder = new Feeder(speedsTab);
  private final Flywheel flywheel = new Flywheel(speedsTab);
  private final Intake intake = new Intake(speedsTab);
  private final IntakePivot intakePivot = new IntakePivot(speedsTab);

  public RobotContainer() {

  }
}