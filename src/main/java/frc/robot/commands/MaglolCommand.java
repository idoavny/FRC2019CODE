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

public class MaglolCommand extends Command 
{
  private boolean activate;

  public MaglolCommand() 
  {
    requires(Robot.maglol);
  }
  
  public MaglolCommand(boolean activate) 
  {
    this.activate = activate;
  }

  @Override
  protected void initialize() 
  {
    setTimeout(Constants.MagTimeOut);
  }

  @Override
  protected void execute() 
  {
    Robot.maglol.setSolenoid(activate);
    Robot.maglol.setSpeed(Constants.MagSpeed);
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
    Robot.maglol.setSolenoid(!activate);
    Robot.maglol.setSpeed(-Constants.MagSpeed);
  }
}
