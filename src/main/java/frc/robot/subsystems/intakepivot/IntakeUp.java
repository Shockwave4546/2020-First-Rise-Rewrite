package frc.robot.subsystems.intakepivot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeUp extends CommandBase {
	private final IntakePivot pivot;
  
	public IntakeUp(IntakePivot pivot) {
		this.pivot = pivot;
	}

	@Override public void initialize() {
		pivot.stop();
	}

	@Override public void execute() {
		pivot.run(true);
	}

	@Override public boolean isFinished() {
		return pivot.topSwitch();
	}

	@Override public void end(boolean interrupted) {
		pivot.stop();
	}
}
