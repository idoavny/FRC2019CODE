/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class PID extends Command {
  private boolean Auto;
  private boolean isReverse;
  private int level;
  private double E;
  private double SumE = 0;
  private double P;
  private double CurrentPosition;
  private double SetPoint;
  private double M;
  private double I;
  
  public PID() {
    requires(Robot.elevator);
  }

  public PID(int level,boolean auto, boolean isReverse) {
    this.level = level;
    this.Auto = auto;
    this.isReverse = isReverse;
  }

 

  @Override
  protected void initialize() {
    switch(level)
    {
      case 0:
      SetPoint = 0;
      break;

      case 1:
      SetPoint = 2000;
      break;

      case 2:
      SetPoint = 2000;
      break;

      case 3:
      SetPoint = 2000;
      break;

      case 4:
      SetPoint = 2000;
      break;

      case 5:
      SetPoint = 2000;
      break;

      case 6:
      SetPoint = 2000;
      break;
    }
    P = Constants.PIDconstants.P.Value();
    I = Constants.PIDconstants.I.Value();
  }
  
  @Override
  protected void execute() {
    if(Auto){
      CurrentPosition = Robot.elevator.EncoderPulses();
      E = (CurrentPosition-SetPoint)/8000;
      SumE = SumE + E;
      M = P*E + SumE*I;
      Robot.elevator.SetSpeed(-M);
    }
   else{
     if(!isReverse){
      Robot.elevator.SetSpeed(0.7);
     }else{
      Robot.elevator.SetSpeed(-0.4);
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

  public double getValue(){
    return -M;
  }
}