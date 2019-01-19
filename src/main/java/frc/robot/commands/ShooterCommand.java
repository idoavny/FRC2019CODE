/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ShooterCommand extends Command 
{
  boolean isReverse;
  public ShooterCommand() 
  {
    requires(Robot.Shooter);
  }
  public ShooterCommand(boolean isReverse) 
  {
    this.isReverse = isReverse;
  }

  @Override
  protected void initialize() 
  {
  
  }

  @Override
  protected void execute() 
  {
   if(isReverse)
    {
      Robot.Shooter.SetSpeed(-0.5);
    }
   else
    {
      Robot.Shooter.SetSpeed(0.5);
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
    Robot.Shooter.SetSpeed(0);
  }
}
