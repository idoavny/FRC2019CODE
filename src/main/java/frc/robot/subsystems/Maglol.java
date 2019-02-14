/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.Constants;
import frc.robot.RobotMap;
/*** 
 Maglol Subsystem:

 motor working both ways.
 limit switch to know if there is a Ball inside the system.
 two selenoids to open and close the system. 
 ***/

public class Maglol extends Subsystem 
{
  AnalogInput AI = new AnalogInput(RobotMap.AnalogIn);  //TODO: put real analog input channel
  Potentiometer pot = new AnalogPotentiometer(AI, Constants.fullrange, Constants.offSet); //TODO: put real values

  private Talon pickMotor = new Talon(RobotMap.MAGLOL_MOTOR);
  private Talon motor2 = new Talon(RobotMap.MAGLOL_RIGHT_ROATION);
  private Talon motor3 = new Talon(RobotMap.MAGLOL_LEFT_ROATION);

  public void setSpeed(Double speed, int choice,Boolean reverse)
  {
    if(reverse = false){
      switch(choice)
      {
        case 1:
          pickMotor.set(speed);
          break;
        case 2:
          motor2.set(speed);
          motor3.set(-speed);
          break;
      }
    }
    else{
      switch(choice)
      {
        case 1:
          pickMotor.set(-speed);
          break;
        case 2:
          motor2.set(-speed);
          motor3.set(speed);
          break;
      }
    }
    
  }

  public double  getAngle() {
    return pot.get();
  }

  @Override
  public void initDefaultCommand() 
  {
   
  }
}