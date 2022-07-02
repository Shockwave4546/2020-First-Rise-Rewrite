package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class MotoredSubsystem extends SubsystemBase {
  public abstract void run(double speed);

  public abstract void run(boolean reversed);

  public abstract void stop();
}