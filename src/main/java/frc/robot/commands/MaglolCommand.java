/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class MaglolCommand extends Command 
{
  private boolean Pick;
  private boolean isReverse;
  private double DesiredAngle;
  private double currentAngle;
  public MaglolCommand() 
  {
    requires(Robot.maglol);
  }

  public MaglolCommand(boolean Pick,boolean isReverse, double DesiredAngle) {
    this.Pick = Pick;
    this.isReverse = isReverse;
    this.DesiredAngle = DesiredAngle;

  }

  @Override
  protected void initialize() 
  {
  }

  @Override
  protected void execute() 
  {
    if(Pick){
      Robot.maglol.setSpeed(Constants.MagSpeed, 0, isReverse);
    }else{
      while(currentAngle != DesiredAngle){
        if(currentAngle > DesiredAngle){
          Robot.maglol.setSpeed(Constants.MagSpeed, 2,false);
        }
        else{
          Robot.maglol.setSpeed(Constants.MagSpeed, 2,true);
        }
      }
     setTimeout(Constants.MagTimeOut);
    }
  }

  @Override
  protected boolean isFinished() 
  {
    return isTimedOut();
  }

  @Override
  protected void end() 
  {
    Robot.maglol.setSpeed(0.0, 2, false);

  }

  @Override
  protected void interrupted() 
  {
    Robot.maglol.setSpeed(Constants.MagSpeedinterrapted, 2, false);
    Robot.maglol.setSpeed(Constants.MagSpeedinterrapted, 1, false);
  }
}