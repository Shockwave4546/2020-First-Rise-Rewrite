package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class MotoredSubsystem extends SubsystemBase {
  public abstract void run(double speed);

  public abstract void run(boolean reversed);

  public abstract void stop();

  public final Command asCommand(boolean reversed) {
    return new CommandBase() {
      @Override public void initialize() {
        stop();
      }

      @Override public void execute() {
        run(reversed);
      }
    
      @Override public void end(boolean interrupted) {
        stop();
      }
    };
  }

  public final Command asCommand() {
    return asCommand(false);
  }

  public final Command asCommand(double speed) {
    return new CommandBase() {
      @Override public void initialize() {
        stop();
      }

      @Override public void execute() {
        run(speed);
      }
    
      @Override public void end(boolean interrupted) {
        stop();
      }
    };
  }
}