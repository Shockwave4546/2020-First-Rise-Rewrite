package frc.robot.api.motor;

import java.time.temporal.TemporalAmount;

import frc.robot.api.command.TimedCommand;

/**
 * 
 * 
 * 
 * 
 * 
 * REWRITE THIS WHOLE MOTOR THING, AS THIS IS NOT VERY FLEXIBLE, IT ONLY LETS YOU USE THE SPEED ON SHUFFLEBOARD, SO LIKE FOR AUTO, IF U WANNA GO A DIFFERENT SPEED... GOOD LUCK LOL
 * 
 * 
 * 
 * 
 * 
 */









public abstract class SimpleMotorCommand<T extends SimpleMotorSubsystem> extends TimedCommand {
  public final T subsystem;
  private final boolean inverted;

  public SimpleMotorCommand(T subsystem, boolean inverted, TemporalAmount duration) {
    super(duration);
    this.subsystem = subsystem;
    this.inverted = inverted;
    addRequirements(subsystem);
  }

  public SimpleMotorCommand(T subsystem, boolean inverted) {
    this(subsystem, inverted, null);
  }

  @Override public void initialize() {
    super.initialize();
    subsystem.stopMotors();
  }

  @Override public void execute() {
    subsystem.runMotors(inverted);
  }

  @Override public void end(boolean interrupted) {
    subsystem.stopMotors();
  }
}