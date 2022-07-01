package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private final RobotContainer container = new RobotContainer();

  @Override public void robotInit() {

  }

  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override public void disabledInit() {}

  @Override public void disabledPeriodic() {}

  @Override public void autonomousInit() {}

  @Override public void autonomousPeriodic() {}

  @Override public void teleopInit() {
    container.drivetrain.initTeleop();
  }

  @Override public void teleopPeriodic() {}

  @Override public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override public void testPeriodic() {}
}