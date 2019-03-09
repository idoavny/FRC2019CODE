/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class JoyStickCommand extends Command {
  private double RT = Robot.m_oi.xbox.getTriggerAxis(Hand.kRight);
  private double LT = Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft);
  private double speed = Robot.m_oi.xbox.getY(Hand.kLeft);
  private boolean isPressed;
  private double RightSpeed;
  private double leftSpeed;

  public JoyStickCommand() {
    requires(Robot.drive);
  } 

  @Override
  protected void initialize() {
    isPressed = false;
  }

  @Override
  protected void execute() {
    if(Robot.m_oi.xbox.getBButton()){
      if(RT <= -0.5){
        Robot.drive.setTankSpeed(speed, -speed);
      }
      if(LT <= -0.5){
        Robot.drive.setTankSpeed(-speed, speed);
      }
    }
    else{
      Robot.drive.setTankSpeed((1-RT)*speed,(1-LT)*-speed);
    }
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
    Robot.drive.setTankSpeed(0, 0);
  }
}