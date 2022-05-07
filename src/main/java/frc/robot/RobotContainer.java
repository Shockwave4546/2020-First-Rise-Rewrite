package frc.robot;

import frc.robot.api.controller.ShockwaveController;

public class RobotContainer {
  private final ShockwaveController driveController = new ShockwaveController(Constants.Controller.DRIVE_PORT);
  private final ShockwaveController operatorController = new ShockwaveController(Constants.Controller.OPERATOR_PORT);

  public RobotContainer() {

  }
}