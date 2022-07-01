package frc.robot.api.shuffleboard;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class AdjustableBoolean extends AdjustableValue<Boolean, AdjustableBoolean> {
  public AdjustableBoolean(ShuffleboardTab tab, String name) {
    widget(BuiltInWidgets.kBooleanBox);
    def(false);
    addTo(tab, name);
  }

  @Override public Boolean get() {
    return entry.getBoolean(def);
  }
}