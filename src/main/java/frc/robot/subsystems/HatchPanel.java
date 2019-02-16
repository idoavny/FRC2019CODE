/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Hatchpanel extends Subsystem {
  Solenoid solenoid = new Solenoid(RobotMap.HatchPanel.solenoidPort.getValue());
  Talon motor = new Talon(RobotMap.HatchPanel.TalonPWM.getValue());
 
  public void setSolenoid(boolean on){
    solenoid.set(on);
  }

  public void setSpeed(double speed){
    motor.set(speed);;
  }

  public void stop(){
    motor.set(0);
  }

  public void Disable(){
    motor.set(0);
    solenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
