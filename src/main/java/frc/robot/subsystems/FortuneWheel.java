package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;
import frc.robot.Constants.Tabs;
import frc.robot.utils.ShuffleboardSpeed;

// TODO: I don't know how the game logic works, so implement later...
public class FortuneWheel extends MotoredSubsystem {
  private static final Color BLUE = new Color(0.143, 0.427, 0.429);
  private static final Color GREEN = new Color(0.197, 0.561, 0.240);
  private static final Color RED = new Color(0.561, 0.232, 0.114);
  private static final Color YELLOW = new Color(0.361, 0.524, 0.113);
  private final MotorController fortuneWheel = new WPI_VictorSPX(Constants.FortuneWheel.MOTOR_ID);
  private final ShuffleboardSpeed speed = new ShuffleboardSpeed(Tabs.SPEEDS, "Fortune Wheel Speed", Constants.FortuneWheel.DEFAULT_SPEED);
  private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
  private final ColorMatch colorMatch = new ColorMatch();

  public FortuneWheel() {
    colorMatch.addColorMatch(BLUE);
    colorMatch.addColorMatch(GREEN);
    colorMatch.addColorMatch(RED);
    colorMatch.addColorMatch(YELLOW);
  }

  @Override public void run(double speed) {
    fortuneWheel.set(speed);
  }

  @Override public void run(boolean reversed) {
    fortuneWheel.set(speed.get() * (reversed ? -1 : 1));
  }

  @Override public void stop() {
    fortuneWheel.stopMotor();
  }

  public Color nearestColor() {
    return colorMatch.matchClosestColor(colorSensor.getColor()).color;
  }
}