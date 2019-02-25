/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LImitswitch extends Command {
  public LImitswitch() {
    requires(Robot.elevator);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    while(Robot.elevator.limitSwitch() == false && Robot.elevator.limitSwitch2() == false){
      Robot.elevator.SetSpeed(-0.2);
    }
    Robot.elevator.SetSpeed(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    while(Robot.elevator.limitSwitch() == false){
      Robot.elevator.SetSpeed(-0.2);
    }
    while(Robot.elevator.limitSwitch()){
      Robot.elevator.SetSpeed(0.2);
      Robot.elevator.EncoderReset();
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
    Robot.elevator.SetSpeed(0);
  }
}