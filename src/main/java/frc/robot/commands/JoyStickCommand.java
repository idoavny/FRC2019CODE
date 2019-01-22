/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;



import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;

public class JoyStickCommand extends Command {
  public JoyStickCommand() {
    requires(Robot.drive);
  }

  @Override
  protected void initialize() {

  }

  @Override
  protected void execute() {
    Robot.drive.setTankSpeed(-Robot.m_oi.rightJoy.getY(), Robot.m_oi.leftJoy.getY());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {
    Robot.drive.setTankSpeed(Constants.Tankspeed, Constants.Tankspeed);
  }
}
