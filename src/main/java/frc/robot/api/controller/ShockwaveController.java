package frc.robot.api.controller;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.utils.Lazy;

/**
 * Represents an Xbox controller.
 */
public class ShockwaveController extends GenericHID {
  public enum Button {
    LEFT_BUMPER(5),
    RIGHT_BUMPER(6),
    LEFT_STICK(9),
    RIGHT_STICK(10),
    A(1),
    B(2),
    X(3),
    Y(4),
    BACK(7),
    START(8);

    public final int value;
    
    Button(int value) {
      this.value = value;
    }
  }

  public enum Axis {
    LEFT_X(0),
    RIGHT_X(4),
    LEFT_Y(1),
    RIGHT_Y(5),
    LEFT_TRIGGER(2),
    RIGHT_TRIGGER(3);

    public final int value;

    Axis(int value) {
      this.value = value;
    }
  }

  public final Lazy<JoystickButton> leftBumper = Lazy.of(() -> new JoystickButton(this, Button.LEFT_BUMPER.value));
  public final Lazy<JoystickButton> rightBumper = Lazy.of(() -> new JoystickButton(this, Button.RIGHT_BUMPER.value));
  public final Lazy<JoystickButton> leftStick = Lazy.of(() -> new JoystickButton(this, Button.LEFT_STICK.value));
  public final Lazy<JoystickButton> rightStick = Lazy.of(() -> new JoystickButton(this, Button.RIGHT_STICK.value));
  public final Lazy<JoystickButton> aButton = Lazy.of(() -> new JoystickButton(this, Button.A.value));
  public final Lazy<JoystickButton> bButton = Lazy.of(() -> new JoystickButton(this, Button.B.value));
  public final Lazy<JoystickButton> xButton = Lazy.of(() -> new JoystickButton(this, Button.X.value));
  public final Lazy<JoystickButton> yButton = Lazy.of(() -> new JoystickButton(this, Button.Y.value));
  public final Lazy<JoystickButton> backButton = Lazy.of(() -> new JoystickButton(this, Button.BACK.value));
  public final Lazy<JoystickButton> startButton = Lazy.of(() -> new JoystickButton(this, Button.START.value));

  public ShockwaveController(int port) {
    super(port);
  }

  public double getLeftX() {
    return getRawAxis(Axis.LEFT_X.value);
  }

  public double getLeftY() {
    return getRawAxis(Axis.LEFT_Y.value);
  }

  public double getRightX() {
    return getRawAxis(Axis.RIGHT_X.value);
  }

  public double getRightY() {
    return getRawAxis(Axis.RIGHT_Y.value);
  }

  public double getLeftTrigger() {
    return getRawAxis(Axis.LEFT_TRIGGER.value);
  }

  public double getRightTrigger() {
    return getRawAxis(Axis.LEFT_TRIGGER.value);
  }

  public boolean isLeftBumperHeld() {
    return getRawButton(Button.LEFT_BUMPER.value);
  }

  public boolean isLeftBumperPressed() {
    return getRawButtonPressed(Button.LEFT_BUMPER.value);
  }

  public boolean isLeftBumperReleased() {
    return getRawButtonReleased(Button.LEFT_BUMPER.value);
  }

  public boolean isRightBumperHeld() {
    return getRawButton(Button.RIGHT_BUMPER.value);
  }

  public boolean isRightBumperPressed() {
    return getRawButtonPressed(Button.RIGHT_BUMPER.value);
  }

  public boolean isRightBumperReleased() {
    return getRawButtonReleased(Button.RIGHT_BUMPER.value);
  }

  public boolean isLeftStickHeld() {
    return getRawButton(Button.LEFT_STICK.value);
  }

  public boolean isLeftStickPressed() {
    return getRawButtonPressed(Button.LEFT_STICK.value);
  }

  public boolean isLeftStickReleased() {
    return getRawButtonReleased(Button.LEFT_STICK.value);
  }

  public boolean isRightStickHeld() {
    return getRawButton(Button.RIGHT_STICK.value);
  }

  public boolean isRightStickPressed() {
    return getRawButtonPressed(Button.RIGHT_STICK.value);
  }

  public boolean isRightStickReleased() {
    return getRawButtonReleased(Button.RIGHT_STICK.value);
  }

  public boolean isAHeld() {
    return getRawButton(Button.A.value);
  }

  public boolean isAPressed() {
    return getRawButtonPressed(Button.A.value);
  }

  public boolean isAReleased() {
    return getRawButtonReleased(Button.A.value);
  }

  public boolean isBHeld() {
    return getRawButton(Button.B.value);
  }

  public boolean isBPressed() {
    return getRawButtonPressed(Button.B.value);
  }

  public boolean isBReleased() {
    return getRawButtonReleased(Button.B.value);
  }

  public boolean isXHeld() {
    return getRawButton(Button.X.value);
  }

  public boolean isXPressed() {
    return getRawButtonPressed(Button.X.value);
  }

  public boolean isXReleased() {
    return getRawButtonReleased(Button.X.value);
  }

  public boolean isYHeld() {
    return getRawButton(Button.Y.value);
  }

  public boolean isYPressed() {
    return getRawButtonPressed(Button.Y.value);
  }

  public boolean isYReleased() {
    return getRawButtonReleased(Button.Y.value);
  }

  public boolean isBackHeld() {
    return getRawButton(Button.BACK.value);
  }

  public boolean isBackPressed() {
    return getRawButtonPressed(Button.BACK.value);
  }

  public boolean isBackReleased() {
    return getRawButtonReleased(Button.BACK.value);
  }

  public boolean isStartHeld() {
    return getRawButton(Button.START.value);
  }

  public boolean isStartPressed() {
    return getRawButtonPressed(Button.START.value);
  }

  public boolean isStartReleased() {
    return getRawButtonReleased(Button.START.value);
  }
}