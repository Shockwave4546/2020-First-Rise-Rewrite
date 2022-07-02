package frc.robot.subsystems.intakepivot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeDown extends CommandBase {
	private final IntakePivot pivot;
  
	public IntakeDown(IntakePivot pivot) {
		this.pivot = pivot;
	}

	@Override public void initialize() {
		pivot.stop();
	}

	@Override public void execute() {
		pivot.run(false);
	}

	@Override public boolean isFinished() {
		return pivot.bottomSwitch();
	}

	@Override public void end(boolean interrupted) {
		pivot.stop();
	}
}
