// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */
  private SparkMax m_motor1;
  private SparkMax m_motor2;

  private DigitalInput m_bottomLimitSwitch;
  private DigitalInput m_topLimitSwitch; 
  
  
  public ElevatorSubsystem(SparkMax motor1, SparkMax motor2, DigitalInput bottomLimitSwitch, DigitalInput topLimitSwitch) {
    m_motor1 = motor1;
    m_motor2 = motor2;
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kBrake);
    config.inverted(true);
    m_motor1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_motor2.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    m_bottomLimitSwitch = bottomLimitSwitch;
    m_topLimitSwitch = topLimitSwitch;
  }

  public void setPower(double power) {
    if(getBottomLimitSwitch() == true && power < 0) {
      power = 0;
    }
    if (getTopLimitSwitch() == true && power > 0) {
      power = 0;
    }
    m_motor1.set(power);
    m_motor2.set(power);
  }

  public boolean getBottomLimitSwitch() {
    return m_bottomLimitSwitch.get();
  }

  public boolean getTopLimitSwitch() {
    return m_topLimitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
