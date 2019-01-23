/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;




import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class HatchCommad extends Command 
{
  private int case1;
  public HatchCommad() 
  {
    requires(Robot.hatchPanel);
  }

  public HatchCommad(int case1)
  {
    requires(Robot.hatchPanel);
    this.case1 = case1;
  }

  @Override
  protected void initialize() 
  {

  }

  @Override
  protected void execute() 
  {
    switch(case1)
    {

      case 1:     //drop a hatchpanel
        Robot.hatchPanel.SetSelenoids(true);
        Timer.delay(Constants.HatchPaneldelay);
        Robot.hatchPanel.SetSelenoids(false);
      break;

      case 2:     // hatchpanel mover goes 90 degrees (from 0)
        double degrees1 = Robot.hatchPanel.potentiometer.get();
        while (degrees1<Constants.Hatchpanel90deg)
        {
        Robot.hatchPanel.SetTalonSpeed(Constants.HatchPanelTurningSpeed);
        degrees1 = Robot.hatchPanel.potentiometer.get();
        }
      break;

      case 3:     // hatchpanel mover goes -90 degrees (from 90)
       degrees1 = Robot.hatchPanel.potentiometer.get();
        while (degrees1>Constants.Hatchpanel0deg) //this is because I dont want to break the motor
        {
        Robot.hatchPanel.SetTalonSpeed(-Constants.HatchPanelTurningSpeed);
        degrees1 = Robot.hatchPanel.potentiometer.get();
        }
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
    
  }
}
