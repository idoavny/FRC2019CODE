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

public class MaglolCommand extends Command 
{
  public double D;
  private double E;
  private double M;
  private double P;
  private double I;
  private double SumE;
  private double Elast = 0;
  private double speed;
  private boolean Pick;
  private boolean isReverse;
  private double DesiredAngle;
  private double currentAngle;
  private boolean toAngle;
  private boolean isPressed;
  public boolean onPoint;
  private boolean toFinish;
  private boolean open;


  private int openOrClose;
  public MaglolCommand() 
  {
    requires(Robot.maglol);
  }

  public MaglolCommand(boolean Pick,double speed, boolean isReverse) {
    requires(Robot.maglol);
    this.Pick = Pick;
    this.isReverse = isReverse;
    this.speed = speed;
  }
  public MaglolCommand(int openOrClose, boolean toAngle,boolean toFinish){
    requires(Robot.maglol);
    this.toAngle = toAngle;
    this.openOrClose = openOrClose;
    this.toFinish = toFinish;
  }

  @Override
  protected void initialize() 
  {
    open = false;
    onPoint = false;
    P = Constants.MaglolPID.P.Value();
    I = Constants.MaglolPID.I.Value();
    D = Constants.MaglolPID.D.Value();
    switch(openOrClose){
      case 1:
      DesiredAngle = 234;
      break;
      case 2:
      DesiredAngle = 310;
      break;
    }

  }

  @Override
  protected void execute() 
  {
    if(toAngle){
      currentAngle = Robot.maglol.PotentiometerValue();
      E = (DesiredAngle-currentAngle);
      SumE = SumE + E;
      M = P*E + SumE*I + D*((Elast - E)/0.02);
      M = M/310;
      Elast = E;
      if(M > 0.5){
        M = 0.5;
      }
      if(M < -0.5){
        M = -0.5;
      }
      Robot.maglol.setSpeed(-M);
    }else{
      speed = -Robot.m_oi.ButtonJoy.getY()*0.5;
      
      Robot.maglol.setSpeed(-Robot.m_oi.ButtonJoy.getY());

    }
    SmartDashboard.putNumber("DesiredMAglolAngle", DesiredAngle);
    if(currentAngle <= DesiredAngle + 2 && currentAngle >= DesiredAngle - 2){
      onPoint = true;
     }else{
       onPoint = false;
     }
     if(currentAngle <= 236 + 2 && currentAngle >= 236 - 2){
      open = true;
     }else{
       open = false;
     }
  }
    public boolean getonPoint(){
      return onPoint;
    }
    public boolean getopenPoint(){
      return open;
    }
  @Override
  protected boolean isFinished() 
  {
    boolean isfinished;
    if(toFinish){
      isfinished = onPoint;
    }else{
      isfinished = false;
    }
    
    return isfinished;
  }

  @Override
  protected void end() 
  {
    Robot.maglol.setSpeed(0.0);
  }

  @Override
  protected void interrupted() 
  {
    Robot.maglol.setPickSpeed(0.0, false);
    Robot.maglol.setSpeed(0.0);
  }
}