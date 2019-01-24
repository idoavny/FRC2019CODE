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

public class ShooterCommand extends Command 
{
  private boolean activate;

  public ShooterCommand() 
  {
    requires(Robot.Shooter);
  }
  public ShooterCommand(boolean activate) 
  {
    this.activate = activate;
  }

  @Override
  protected void initialize() 
  {
  
  }

  @Override
  protected void execute() 
  {
    Robot.Shooter.setSolenoid(activate);
    Robot.Shooter.setSpeed(Constants.ShooterSpeed);
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
    Robot.Shooter.setSolenoid(!activate);
    Robot.Shooter.setSpeed(-Constants.ShooterSpeed);
  }
}