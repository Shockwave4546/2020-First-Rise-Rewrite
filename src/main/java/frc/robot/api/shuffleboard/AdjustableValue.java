package frc.robot.api.shuffleboard;

import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public abstract class AdjustableValue<T, V extends AdjustableValue<T, V>> implements Supplier<T> {
  private Map<String, Object> properties;
  private BuiltInWidgets widget;
  private Pos2D pos;
  protected T def;
  protected NetworkTableEntry entry;

  @SuppressWarnings("unchecked")
  public V properties(Map<String, Object> properties) {
    this.properties = properties;
    return (V) this;
  }

  @SuppressWarnings("unchecked")
  public V widget(BuiltInWidgets widget) {
    this.widget = widget;
    return (V) this;
  }

  @SuppressWarnings("unchecked")
  public V pos(Pos2D pos) {
    this.pos = pos;
    return (V) this;
  }

  @SuppressWarnings("unchecked")
  public V def(T def) {
    this.def = def;
    return (V) this;
  }

  @SuppressWarnings("unchecked")
  public V addTo(ShuffleboardTab tab, String name) {
    final var entry = tab.add(name, def)
      .withWidget(widget)
      .withProperties(properties);
    if (pos != null) entry.withPosition(pos.x, pos.y);
    this.entry = entry.getEntry();
    return (V) this;
  }

  public NetworkTableEntry getRaw() {
    if (entry == null) throw new RuntimeException("lol don't be dumb");
    return entry;
  }

  public void set(T value) {
    entry.setValue(value);
  }
}