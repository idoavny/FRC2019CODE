/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;




import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ForkCommad extends Command {
  private String Mode;

  public ForkCommad() {
    requires(Robot.fork);
  }

  public ForkCommad(String Mode)
  {
    requires(Robot.fork);
    this.Mode = Mode;
  }

  @Override
  protected void initialize() 
  {

  }

  @Override
  protected void execute() 
  {
    switch(Mode)
    {
      case "pick":
      Robot.fork.setSpeed(0.9, 0, false);
      break;

      case "shoot":
      Robot.fork.setSpeed(0.9, 1, true);
      Timer.delay(2);
      Robot.fork.setSpeed(0.9, 2, true);
      break;

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
    Robot.fork.setSpeed(0, 0, false);
    Robot.fork.SetSelenoids(true);
  }
}