/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Fork extends Subsystem {

  // public Potentiometer potentiometer = new
  // AnalogPotentiometer(RobotMap.HPpotentiometer, 360, 0);
  private Talon motor1 = new Talon(RobotMap.Fork.HPmotor1.getValue());
  private Talon motor2 = new Talon(RobotMap.Fork.HPmotor2.getValue());
  SpeedControllerGroup shoot = new SpeedControllerGroup(motor1, motor2);
  private Talon motor3 = new Talon(RobotMap.Fork.HPmotor3.getValue());
  public Solenoid solenoid1 = new Solenoid(RobotMap.Fork.HPsolonoid1.getValue());
  private DigitalInput limitSwitch = new DigitalInput((int)Constants.Fork.forklimitswitch.Value());

  public Fork() {
   motor2.setInverted(true);
  }
  
  public void setShootSpeed(double speed, boolean reverse)
  {
    if(!reverse){
      motor1.set(speed);
      motor2.set(speed);  
    }
    else{
      motor1.set(-speed);
      motor2.set(-speed);
    }

  }
  
  public void setOutSpeed(double speed, boolean reverse)
  {
    if(!reverse){
      motor3.set(speed);
    }
    else{
      motor3.set(-speed);
    }
  }
  
  public void SetSelenoids(boolean mode)
  {
    solenoid1.set(mode);
  }

  public void GetLimitSwitch()
  {
    limitSwitch.get();
  }
  
  @Override
  public void initDefaultCommand() 
  {
    
  }
}