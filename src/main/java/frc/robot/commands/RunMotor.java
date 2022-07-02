package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotoredSubsystem;

public class RunMotor extends CommandBase {
  private final MotoredSubsystem subsystem;
  private boolean reversed = false;
  private double speed = Double.MAX_VALUE;

  public RunMotor(MotoredSubsystem subsystem, boolean reversed) {
    this.subsystem = subsystem;
    addRequirements(subsystem);
  }

  public RunMotor(MotoredSubsystem subsystem) {
    this(subsystem, false);
  }

  public RunMotor(MotoredSubsystem subsystem, double speed) {
    this.subsystem = subsystem;
    this.speed = speed;
    addRequirements(subsystem);
  }

  @Override public void initialize() {
    subsystem.stop();
  }

  @Override public void execute() {
    if (speed == Double.MAX_VALUE) subsystem.run(reversed);
    else subsystem.run(speed);
  }

  @Override public void end(boolean interrupted) {
    subsystem.stop();
  }
}