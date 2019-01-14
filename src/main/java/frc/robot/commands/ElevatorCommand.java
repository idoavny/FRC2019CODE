/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorCommand extends Command {
  int mode = 0;

  public ElevatorCommand() {
    requires(Robot.ELEV);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    Robot.ELEV.getMode(mode);
  }
// ron, this is from all of the programing team,  after you leave please fix your errors because it's anoyying, STOP RETARDATION. thank you. !!README!!
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch(mode)
    {
      case 0:
        
        break;
      case 1:
        
        break;
      case 2:
        
        break;
      case 3:
        
        break;
      case 4:
        
        break;
      case 5:
        
        break;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.ELEV.bringSallyDown(0,0);
  }
}
