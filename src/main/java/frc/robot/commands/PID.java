/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;

public class PID extends Command {
  public double Elast = 0;
  public boolean isReverse;
  private boolean Auto;
  private double E;
  private double SumE = 0;
  private double P;
  private double CurrentPosition;
  private double SetPoint;
  private double M;
  private double I;
  private String mode;  
  private int level;
  public int count;
  public double D;

  private static int previousPov = 0;
  
  public PID() {
    requires(Robot.elevator);
  }

  public PID(String mode,int level, boolean auto, boolean isReverse) {
    requires(Robot.elevator);
    this.mode = mode;
    this.level = level;
    this.Auto = auto;
    this.isReverse = isReverse;
  }

  @Override
  protected void initialize() {
    switch(mode){
      case "Ball":
      switch(level)
      {

        case 1:
        SetPoint = 1950;
        break;

        case 2:
        SetPoint = 6050;
        break;
  
        case 3:
        SetPoint = 8800;
        break;
     
      }
      break;
      case "Hatch":
      switch(level){
        case 1:
        SetPoint = 0;
        break;
  
        case 2:
        SetPoint = 3859;
        break;
  
        case 3:
        SetPoint = 8000;
        break;
      }
    }
    P = Constants.PIDconstants.P.Value();
    I = Constants.PIDconstants.I.Value();
    D = Constants.PIDconstants.D.Value();
  }
  
  @Override
  protected void execute() {
    SmartDashboard.putNumber("desiredPosition", SetPoint);
    if(Auto){
      CurrentPosition = Robot.elevator.EncoderPulses();
      E = (CurrentPosition-SetPoint)/8000;
      SumE = SumE + E;
      M = P*E + SumE*I + D*((Elast - E)/0.02);
      
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
    if(!Robot.elevator.limitSwitch() && Robot.elevator.limitSwitch2())
    {
      count = 0;
      Robot.elevator.EncoderReset();
      if(speed < 0){
        Robot.elevator.SetSpeed(0);

      }
      }
      
      
     
    
    SmartDashboard.putNumber("Elevator Count",count);
   /* if(!Robot.elevator.limitSwitch() && Robot.elevator.limitSwitch2())
    {
      count = 0;
      Robot.elevator.EncoderReset();
      if(isReverse){
        Robot.elevator.SetSpeed(0);
      }
    }*/
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