// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ElevatorSubsystem.ElevatorSetPoints;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ElevatorCommand extends Command {

  private final ElevatorSubsystem m_elevatorSubsystem;
  private final Supplier<Double> m_Yvalue;
  private final Supplier<Boolean> m_a;
  private final Supplier<Boolean> m_b;
  private final Supplier<Boolean> m_x;
  private final Double POWER_LIMIT = 0.4;
  public static final double DEADBAND = 0.1;

  /** Creates a new elevator. */
  public ElevatorCommand(ElevatorSubsystem elevatorSubsystem, Supplier <Double> Yvalue, Supplier<Boolean> m_a, Supplier<Boolean> m_b, Supplier<Boolean> m_x) {
    // Use addRequirements() here to declare subsystem dependencies.
   m_elevatorSubsystem = elevatorSubsystem;
   m_Yvalue = Yvalue;
   m_a = aInput;
   m_b = bInput;
   m_x = xInput;
   addRequirements(m_elevatorSubsystem);
  }
@Override
public void initialize(){

}
@Override
public void execute() {
  double Yvalue = -m_Yvalue.get(); // invert y value so that up is positive
  Yvalue = MathUtil.applyDeadband(Yvalue, DEADBAND);
 m_elevatorSubsystem.setPower(POWER_LIMIT*Yvalue);
 double aInput = m_a.get();
 m_elevatorSubsystem.setSetpoint(ElevatorSetPoints.LEVEL1);
 double bInput = m_b.get();
 m_elevatorSubsystem.setSetpoint(ElevatorSetPoints.LEVEL2);
 double xInput = m_x.get();
 m_elevatorSubsystem.setSetpoint(ElevatorSetPoints.LEVEL3);

}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
