/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Fork extends Subsystem {

  // public Potentiometer potentiometer = new
  // AnalogPotentiometer(RobotMap.HPpotentiometer, 360, 0);
  private Talon motor1 = new Talon(RobotMap.Fork.HPmotor1.getValue());
  private Talon motor2 = new Talon(RobotMap.Fork.HPmotor2.getValue());
  SpeedControllerGroup shoot = new SpeedControllerGroup(motor1, motor2);
  private Talon motor3 = new Talon(RobotMap.Fork.HPmotor3.getValue());
  private Solenoid solenoid1 = new Solenoid(RobotMap.Fork.HPsolonoid1.getValue());

  public Fork() {
   motor2.setInverted(true);
 }
  public void setSpeed(double speed, int motor, boolean reverse)
  {
    if(reverse){
        switch(motor){
          case 0:
          shoot.set(speed);
          motor3.set(speed);
          break;
          case 1:
          shoot.set(speed);
          break;
          case 2:
          motor3.set(speed);
        }
      }
    else{
      switch(motor){
        case 0:
        shoot.set(-speed);
        motor3.set(-speed);
        break;
        case 1:
        shoot.set(-speed);
        break;
        case 2:
        motor3.set(-speed);
      }
    } 
  }
  
  public void SetSelenoids(boolean mode)
  {
    solenoid1.set(mode);
  }
  
 
  
  @Override
  public void initDefaultCommand() 
  {
    
  }
}
