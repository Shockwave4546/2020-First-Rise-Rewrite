package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopTankDrive extends CommandBase {
  private final XboxController controller;
  private final Drivetrain drivetrain;

  public TeleopTankDrive(XboxController controller, Drivetrain drivetrain) {
    this.controller = controller;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override public void initialize() {
    drivetrain.stop();
  }

  @Override public void execute() {
     drivetrain.tankDrive(controller.getLeftY(), controller.getRightY());
  }

  @Override public void end(boolean interrupted) {
    drivetrain.stop();
  }
}