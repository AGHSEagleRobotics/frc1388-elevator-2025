// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  private final DigitalInput m_bottomLimitSwitch;
  private final DigitalInput m_upperLimitSwitch;
  private final SparkMax m_elevatorMotor1;
  private final SparkMax m_elevatorMotor2;

  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem(DigitalInput bottomLimitSwitch, DigitalInput upperLimitSwitch, SparkMax elevatorMotor1,
      SparkMax elevatorMotor2) {

    m_bottomLimitSwitch = bottomLimitSwitch;
    m_upperLimitSwitch = upperLimitSwitch;
    m_elevatorMotor1 = elevatorMotor1;
    m_elevatorMotor2 = elevatorMotor2;
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kBrake);
    ;
    m_elevatorMotor1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_elevatorMotor2.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // Removed redundant setIdleMode call as it is not defined for SparkMax
  }

  public void setPower(double power){ 
    if (isAtBottomLimit() && power < 0) {
      power = 0;
    }

    if (isAtUpperLimit() && power > 0) {
      power = 0;
    }


    m_elevatorMotor1.set(power);
    m_elevatorMotor2.set(power);
  }

    private boolean isAtBottomLimit(){
      return m_bottomLimitSwitch.get();
    }
    private boolean isAtUpperLimit(){
      return m_upperLimitSwitch.get();
    }
    

  // if at botttom limit

  // then if power is negative set power to zero

  // if at top limit

  // then if power is postivie set power to zero

  public void CommandXboxController() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
