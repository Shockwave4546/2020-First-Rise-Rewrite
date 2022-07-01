package frc.robot.api.shuffleboard;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class AdjustableSpeed extends AdjustableDouble<AdjustableSpeed> {
  public AdjustableSpeed(ShuffleboardTab tab, String name, double def) {
    super(tab, name);
    range(-1.0, 1.0);
    def(def);
  }

  public AdjustableSpeed(ShuffleboardTab tab, String name) {
    this(tab, name, 0.0);
  }
}