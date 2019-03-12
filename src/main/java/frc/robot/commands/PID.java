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
  public double Elast = 0;
  public boolean isReverse;
  private boolean Auto;
  private double SumE = 0;
  private double CurrentPosition;
  private double SetPoint;
  private boolean onPoint;
  private String mode;  
  private int level;
  public int count;
  public double D;
  private double E;
  private double M;
  private double P;
  private double I;
  private boolean toFinish;


  
  public PID() {
    requires(Robot.elevator);
  }

  public PID(String mode,int level, boolean auto, boolean isReverse,boolean toFinish) {
    requires(Robot.elevator);
    this.mode = mode;
    this.level = level;
    this.Auto = auto;
    this.isReverse = isReverse;
    this.toFinish = toFinish;
  }
  

  @Override
  protected void initialize() {
    onPoint = false;
    switch(mode){
      case "Ball":
      switch(level)
      {

        case 1:
        SetPoint = 2100;
        break;

        case 2:
        SetPoint = 6200;
        break;
  
       /* case 3:
        SetPoint = 8800;
        break;*/
     
      }
      break;
      case "Hatch":
      switch(level){
        case 1:
        SetPoint = 0;
        break;
  
        case 2:
        SetPoint = 3900;
        break;
        
        case 3:
        SetPoint = 8700;
        break;
      }
      break;
      case "Feeder":
      switch(level){
        case 1:
        SetPoint = 4900;
        break;
    }
      break;
      case "Cargo":
      switch(level){
        case 1:
        SetPoint = 1500;
        break;
      }
  }
    P = Constants.PIDconstants.P.Value();
    I = Constants.PIDconstants.I.Value();
    D = Constants.PIDconstants.D.Value();
  }
  
  @Override
  protected void execute() {
    CurrentPosition = Robot.elevator.EncoderPulses();

    SmartDashboard.putNumber("desiredPosition", SetPoint);
    if(Auto){
      E = (CurrentPosition-SetPoint)/8000;
      SumE = SumE + E;
      M = P*E + SumE*I + D*((Elast - E)/0.02);
      Elast = E;
      Robot.elevator.SetSpeed(-M);
    }
    else{
      double speed;
     if(isReverse){
       speed = -0.4;
      Robot.elevator.SetSpeed(speed);
     }else{
       speed = 0.6;
      Robot.elevator.SetSpeed(speed);
     }
    if(
      Robot.elevator.limitSwitch() && Robot.elevator.limitSwitch2())
    {
      count = 0;
      Robot.elevator.EncoderReset();
      if(speed < 0){
        Robot.elevator.SetSpeed(0);
      }
  }
  }
  if(CurrentPosition < SetPoint + 80 && CurrentPosition > SetPoint - 80){
    onPoint = true;
   }else{
     onPoint = false;
   }
   SmartDashboard.putBoolean("ElevatorOnPoint", onPoint);
}
public boolean getonPoint(){
  return onPoint;
}
  @Override
  protected boolean isFinished() {
    boolean isfinished;
    if(toFinish){
      isfinished = onPoint;
    }else{
      isfinished = false;
    }
    
    return isfinished;
  }

  @Override
  protected void end() {
    Robot.elevator.SetSpeed(0);
  }

  @Override
  protected void interrupted() {
    Robot.elevator.SetSpeed(0);
  }
}