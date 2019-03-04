/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MaglolCommand extends Command 
{
  private double speed;
  private boolean Pick;
  private boolean isReverse;
  private double DesiredAngle;
  private double currentAngle;
  private boolean toAngle;
  private boolean isPressed;
  public MaglolCommand() 
  {
    requires(Robot.maglol);
  }

  public MaglolCommand(boolean Pick,double speed, boolean isReverse) {
    this.Pick = Pick;
    this.isReverse = isReverse;
    this.speed = speed;
  }
  public MaglolCommand(double DesiredAngle, boolean toAngle){
    this.DesiredAngle = DesiredAngle;
    this.toAngle = toAngle;
  }

  @Override
  protected void initialize() 
  {

  }

  @Override
  protected void execute() 
  {
    if(Pick){
      Robot.maglol.setPickSpeed(speed, isReverse);
    }
    Robot.maglol.setSpeed(-Robot.m_oi.ButtonJoy.getY()*0.5);
     
    

  }

  @Override
  protected boolean isFinished() 
  {
    return false;
  }

  @Override
  protected void end() 
  {
  }

  @Override
  protected void interrupted() 
  {
    Robot.maglol.setPickSpeed(0.0, false);
    Robot.maglol.setSpeed(0.0);
  }
}