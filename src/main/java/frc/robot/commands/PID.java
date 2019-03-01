/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;

public class PID extends Command {
  public boolean isReverse;
  private boolean Auto;
  private int level;
  private double E;
  private double SumE = 0;
  private double P;
  private double CurrentPosition;
  private double SetPoint;
  private double M;
  private double I;
  private String mode;  
  
  public PID() {
    requires(Robot.elevator);
  }

  public PID(String mode, int level, boolean auto, boolean isReverse, double SetPoint) {
    this.mode = mode;
    this.level = level;
    this.Auto = auto;
    this.isReverse = isReverse;
    this.SetPoint = SetPoint;
  }

  @Override
  protected void initialize() {
  switch(mode){
    case "Ball":
    switch(level)
    {
      case 1:
      SetPoint = 2000;
      break;

      case 2:
      SetPoint = 6000;
      break;

      case 3:
      SetPoint = 8000;
      break;
    }
    break;

    case "Hatch":
    switch(level)
    {
      case 1:
      SetPoint = 0;
      break;

      case 2:
      SetPoint = 4000;
      break;

      case 3:
      SetPoint = 8000;
      break;
    }
    break;
  }
    
    P = Constants.PIDconstants.P.Value();
    I = Constants.PIDconstants.I.Value();
  }
  
  @Override
  protected void execute() {
    SmartDashboard.putNumber("desiredPosition", SetPoint);
    if(Auto){
      CurrentPosition = Robot.elevator.EncoderPulses();
      E = (CurrentPosition-SetPoint)/8000;
      SumE = SumE + E;
      M = P*E + SumE*I;
      
      Robot.elevator.SetSpeed(-M);
    }
    else{
      if(!isReverse){
        Robot.elevator.SetSpeed(0.6);
      }
      else{
      Robot.elevator.SetSpeed(-0.4);
      }
    }
    if(!Robot.elevator.limitSwitch() && Robot.elevator.limitSwitch2())
    {
      Robot.elevator.EncoderReset();
      if(isReverse){
        Robot.elevator.SetSpeed(0);
      }
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    Robot.elevator.SetSpeed(0);
  }
}