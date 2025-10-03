package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.LEDConstants;

import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.configs.LEDConfigs;
import com.ctre.phoenix6.controls.SingleFadeAnimation;
// import com.ctre.phoenix.led.CANdle;
// import com.ctre.phoenix.led.CANdleConfiguration;
// import com.ctre.phoenix.led.RainbowAnimation;
// import com.ctre.phoenix.led.SingleFadeAnimation;
import com.ctre.phoenix6.hardware.CANdle;
// import com.ctre.phoenix.led.CANdle.LEDStripType;
// import com.ctre.phoenix.led.CANdle.LEDStripType;
// import com.ctre.phoenix6.hardware.CANdle.LEDStripType;
import com.ctre.phoenix6.signals.RGBWColor;
// import com.ctre.phoenix.led.CANdle.VBatOutputMode;
import com.ctre.phoenix6.signals.StripTypeValue;

public class LEDSubsystem extends SubsystemBase {

  private final CANdle m_candle; // CANdle canid is 42
  // private final boolean m_isOnRed;

  /** Creates a new LEDSubsystem. */  
  public LEDSubsystem(CANdle candle) {
    m_candle = candle;
    // m_isOnRed = (DriverStation.getAlliance().get() == Alliance.Red);
      CANdleConfiguration config = new CANdleConfiguration();
      config.withLED(new LEDConfigs().withStripType(StripTypeValue.RGB).withBrightnessScalar(0.3));
     m_candle.getConfigurator().apply(config);
     
     
      // m_candle.clearAnimation(0);
      // m_candle.clearAnimation(1);
      // m_candle.clearAnimation(2);

    // SingleFadeAnimation fades = new SingleFadeAnimation(247, 233, 0, 0, 0.2, 47, 0);
    // m_candle.animate(fades);
    SingleFadeAnimation fades = new SingleFadeAnimation(8, 40).withSlot(0).withColor(new RGBWColor(247, 233, 0, 0)).withFrameRate(0.2);
    m_candle.setControl(fades);

}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // if (m_isOnRed) {
    //   m_led.set(LEDConstants.RED_SOLID);
    // } else {
    //   m_led.set(LEDConstants.BLUE_SOLID);
    // }
  }
}