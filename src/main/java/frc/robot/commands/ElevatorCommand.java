/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.logging.Level;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Calculations;
import frc.robot.Constants;
import frc.robot.Robot;
public class ElevatorCommand extends Command 
{ 
 private double CurrentPosition;
 private int Setpoint;
 private boolean disable;
 private int Level;
 private boolean Auto;
// private double waitTime;
// private double LastTimeonTarget;

  
  boolean limitswitch = false;

  public ElevatorCommand() 
  {
    requires(Robot.elevator);
  }
  public ElevatorCommand(boolean Auto){
    this.Auto = Auto;
  }
  public ElevatorCommand(boolean disable, int Setpoint) 
  {
    requires(Robot.elevator);
    this.disable = disable;
    this.Setpoint = Setpoint;
  }

  @Override
  protected void initialize() 
  {
    if(Auto){
      switch(Level){
        case 0:
         Robot.elevator.PIDsetSetpoint(0);
        break;
        case 1:
        Robot.elevator.PIDsetSetpoint(0);
        break;
        case 2:
        Robot.elevator.PIDsetSetpoint(0);
        break;
        case 3:
        Robot.elevator.PIDsetSetpoint(0);
        break;
        case 4:
        Robot.elevator.PIDsetSetpoint(0);
        break;
        case 5:
        Robot.elevator.PIDsetSetpoint(0);
        break;
        case 7:
        Robot.elevator.PIDsetSetpoint(0);
        break;

      }
    }
   // waitTime = Constants.pidWaitTime;
    Robot.elevator.PIDsetSetpoint(Setpoint);
    Robot.elevator.PIDSetAbsoluteTolerance(2);
    Robot.elevator.PIDsetOutRange(0.8,-0.8);

    CurrentPosition = Robot.elevator.EncoderPulses();
    if(CurrentPosition > Setpoint){
      Robot.elevator.setKp(0);
      Robot.elevator.setKi(0);
      Robot.elevator.setKd(0);
    }
    else{
      Robot.elevator.setKp(0);
      Robot.elevator.setKi(0);
      Robot.elevator.setKd(0);
    }
  }
  @Override
  protected void execute() 
  {
    Robot.elevator.PIDEnableOrDisable(true);
  }

  @Override
  protected boolean isFinished() 
  {
    return disable;
    /*if(!Robot.elevator.pid.onTarget()){
      LastTimeonTarget = Timer.getFPGATimestamp();
    }                                                                   if the pid is on target waitTime time the command stops
    return Timer.getFPGATimestamp() - LastTimeonTarget > waitTime;
    */
  }

  @Override
  protected void end() 
  {
    while(Setpoint > 0)
    Robot.elevator.SetSpeed(-0.4);
  }

  @Override
  protected void interrupted() 
  {
    Robot.elevator.SetSpeed(0);
  }
}
