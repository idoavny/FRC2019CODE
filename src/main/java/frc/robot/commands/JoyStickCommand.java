/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class JoyStickCommand extends Command {
  private boolean isPressed;
  private double RightSpeed;
  private double leftSpeed;

  public JoyStickCommand() {
    requires(Robot.drive);
  } 
public JoyStickCommand(double speed){
  Robot.drive.setTankSpeed(speed, speed);
}

  @Override
  protected void initialize() {
    isPressed = false;
  }

  @Override
  protected void execute() {

   // Robot.drive.setTankSpeed((1-Robot.m_oi.RT)*Robot.m_oi.,(1-1-Robot.m_oi.LT)*-Robot.m_oi.speed);
    
   leftSpeed = Robot.m_oi.leftJoy.getY();
   RightSpeed = Robot.m_oi.rightJoy.getY();
    if(Robot.m_oi.rightJoy.getY() > -0.1 && Robot.m_oi.rightJoy.getY() < 0.1){
      RightSpeed = 0;
    }
    if(Robot.m_oi.leftJoy.getY() > -0.1 && Robot.m_oi.leftJoy.getY() < 0.1){
      leftSpeed = 0;
    }

    if(Robot.m_oi.rightJoy.getRawButtonPressed(3)){
      isPressed = !isPressed;
    }
    if(!isPressed){
      Robot.drive.setTankSpeed(-RightSpeed, leftSpeed);
    }
    else{
      Robot.drive.setTankSpeed(leftSpeed, -RightSpeed);
    }
    SmartDashboard.putBoolean("Reverse", isPressed);
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