package frc.robot.utils;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleboardSpeed {
  private final double defaultSpeed;
  private final NetworkTableEntry speedEntry;

  public ShuffleboardSpeed(ShuffleboardTab tab, String name, double defaultSpeed, Pos2D position) {
    this.defaultSpeed = defaultSpeed;
    final var speedEntry = tab.add(name, defaultSpeed)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", "-1", "max", "1"));
    if (position != null) speedEntry.withPosition(position.x, position.y);
    this.speedEntry = speedEntry.getEntry();
  }

  public ShuffleboardSpeed(ShuffleboardTab tab, String name, double defaultSpeed) {
    this(tab, name, defaultSpeed, null);
  }

  public double get() {
    return speedEntry.getDouble(defaultSpeed);
  }

  public NetworkTableEntry getRaw() {
    return speedEntry;
  }

  public void set(double speed) {
    speedEntry.setDouble(speed);
  }
}