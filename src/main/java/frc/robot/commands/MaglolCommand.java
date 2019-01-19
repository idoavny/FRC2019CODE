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
  boolean isReverse;
  public MaglolCommand() 
  {
  
  }
  
  public MaglolCommand(boolean isReverse) 
  {
  this.isReverse = isReverse;
  }

  @Override
  protected void initialize() 
  {
    setTimeout(1);
  }

  @Override
  protected void execute() 
  {
    if(isReverse)
    {
      Robot.maglol.setSpeed(-0.5);
    }
   else
    {
      Robot.maglol.setSpeed(0.5);
    }   
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
    Robot.maglol.setSpeed(0.0); 
  }
}
