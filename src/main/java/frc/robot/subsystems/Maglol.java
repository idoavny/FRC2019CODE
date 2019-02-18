/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.RobotMap;
/*** 
 Maglol Subsystem:

 motor working both ways.
 limit switch to know if there is a Ball inside the system.
 two selenoids to open and close the system. 
 ***/

public class Maglol extends Subsystem 
{
  //AnalogInput AI = new AnalogInput(RobotMap.Maglol.AnalogIn.getValue());  //TODO: put real analog input channel
  Potentiometer pot = new AnalogPotentiometer(0, 360, 71.7);//TODO: put real values

  private TalonSRX pickMotor = new TalonSRX(RobotMap.Maglol.MAG_PICK.getValue());
  private Talon LefttMotor = new Talon(RobotMap.Maglol.MAGLOL_RIGHT_ROATION.getValue());
  private Talon RightMotor = new Talon(RobotMap.Maglol.MAGLOL_LEFT_ROATION.getValue());
 
  public void setPickSpeed(Double speed,boolean isReverse)
  {
    pickMotor.setInverted(isReverse);
    pickMotor.set(ControlMode.PercentOutput, speed);
  }

  public double PotentiometerValue(){
  return pot.get();
  }

  public void setSpeed(Double speed,boolean isReverse)
  {
    if(!isReverse){
      LefttMotor.setSpeed(speed);
      RightMotor.setSpeed(-speed); 
    }
    else {
      LefttMotor.setSpeed(-speed);
      RightMotor.setSpeed(speed);  
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