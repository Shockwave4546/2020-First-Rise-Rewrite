package frc.robot;

import frc.robot.Constants.ControllerPort;
import frc.robot.Constants.Tabs;
import frc.robot.controller.ShockwaveController;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.intakepivot.IntakeDown;
import frc.robot.subsystems.intakepivot.IntakeUp;
import frc.robot.subsystems.intakepivot.IntakePivot;

public class RobotContainer {
  private final ShockwaveController driveController = new ShockwaveController(ControllerPort.DRIVE);
  // private final ShockwaveController operatorController = new ShockwaveController(ControllerPort.OPERATOR);
  protected final Drivetrain drivetrain = new Drivetrain(driveController);
  private final Feeder feeder = new Feeder();
  private final Flywheel flywheel = new Flywheel();
  private final Intake intake = new Intake();
  private final IntakePivot pivot = new IntakePivot();

  public RobotContainer() {
    configureShuffleboard();
    configureController();
  }

  private void configureShuffleboard() {
    Tabs.DEBUG.add(new IntakeDown(pivot));
    Tabs.DEBUG.add(new IntakeUp(pivot));
  }

  private void configureController() {
    driveController.aButton.whileHeld(flywheel.asCommand());
    driveController.bButton.whileHeld(intake.asCommand());
    driveController.xButton.whileHeld(feeder.asCommand());
  }
}