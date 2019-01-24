/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
/*** 
 Maglol Subsystem:

 motor working both ways.
 limit switch to know if there is a Ball inside the system.
 two selenoids to open and close the system. 
 ***/

public class Maglol extends Subsystem 
{
  Solenoid solenoid1 = new Solenoid(1);
  Solenoid solenoid2 = new Solenoid(2);
  private Talon motor1 = new Talon(RobotMap.MAGLOL_MOTOR1);
  private DigitalInput LimitSwitch = new DigitalInput(RobotMap.MAGLOL_LIMIT_SWITCH);

  public boolean isPressed()
  {
    return LimitSwitch.get();
  }

  public void setSpeed(double speed)
  {
    motor1.set(speed);
  }

  public void setSolenoid(boolean activate)
  {
    if(activate == true) {
      solenoid1.set(true);
      solenoid2.set(true);
    }
    else {
      solenoid1.set(false);
      solenoid2.set(false);
    }
  }

  @Override
  public void initDefaultCommand() 
  {
   
  }
}
