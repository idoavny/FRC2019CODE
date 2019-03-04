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
  private String mode;
  private double RightSpeed;
  private double leftSpeed;

  public JoyStickCommand() {
    requires(Robot.drive);
  } 
public JoyStickCommand(double speed){
  Robot.drive.setTankSpeed(speed, speed);
}
  public JoyStickCommand(String mode) {
    this.mode = mode;
  } 

  @Override
  protected void initialize() {
    isPressed = false;
  }

  @Override
  protected void execute() {

    leftSpeed = Robot.m_oi.leftJoy.getY();
    RightSpeed = Robot.m_oi.rightJoy.getY();

    if(Robot.m_oi.rightJoy.getRawButtonPressed(13) || Robot.m_oi.rightJoy.getRawButtonPressed(2)){
      isPressed = !isPressed;
    }
    if(isPressed == false){
      Robot.drive.setTankSpeed(-RightSpeed, leftSpeed);
      if(mode == "Slow"){
        Robot.drive.setTankSpeed(RightSpeed*0.5, -leftSpeed*0.5);
      }
    }
    else{
      Robot.drive.setTankSpeed(leftSpeed, -RightSpeed);
      if(mode == "Slow"){
        Robot.drive.setTankSpeed(-leftSpeed*0.5, RightSpeed*0.5);
      }
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