// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ElevatorCommand;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.LEDSubsystem;

import com.ctre.phoenix6.hardware.CANdle;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's actuators and sensors are included here
  // private final DigitalInput m_bottomLimitSwitch = new DigitalInput(1);
  // private final DigitalInput m_upperLimitSwitch = new DigitalInput(0);
  // private final SparkMax m_elevatorMotor1 = new SparkMax(8, MotorType.kBrushless);
  // private final SparkMax m_elevatorMotor2 = new SparkMax(7, MotorType.kBrushless);
  // This includes the elevator subsystems
// private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem(m_bottomLimitSwitch, m_upperLimitSwitch, m_elevatorMotor1, m_elevatorMotor2);

  private final CANdle m_candle;
  private final LEDSubsystem m_ledSubsystem;


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // create the physical devices used by the LEDSubsystem
    m_candle = new CANdle(42);
    // create the LEDSubsystem
    m_ledSubsystem = new LEDSubsystem(m_candle);


    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
//Alejandro was here
    // m_elevatorSubsystem.setDefaultCommand(
    //   new ElevatorCommand(m_elevatorSubsystem, () -> m_driverController.getRightY())
    // );
  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
