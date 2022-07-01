package frc.robot.api.shuffleboard;

import java.util.Map;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class AdjustableDouble<T extends AdjustableDouble<T>> extends AdjustableValue<Double, T> {
  public AdjustableDouble() {
    widget(BuiltInWidgets.kNumberSlider);
  }

  public AdjustableDouble(ShuffleboardTab tab, String name) {
    this();
    addTo(tab, name);
  }

  public T range(double min, double max) {
    properties(Map.of("min", min, "max", max));
    return (T) this;
  }

  @Override public Double get() {
    return entry.getDouble(def);
  }
}