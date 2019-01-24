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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.RobotMap;


public class HatchPanel extends Subsystem 
{
  public Potentiometer potentiometer = new AnalogPotentiometer(RobotMap.HPpotentiometer, 360, 0);
  private TalonSRX HPmotor = new TalonSRX(RobotMap.HPmotor);

  private Solenoid solenoid1 = new Solenoid(RobotMap.HPsolonoid1);
  private Solenoid solenoid2 = new Solenoid(RobotMap.HPsolonoid2);
  private Solenoid solenoid3 = new Solenoid(RobotMap.HPsolonoid3);

  public void setTalonSpeed(double speed)
  {
    HPmotor.set(ControlMode.PercentOutput, speed);
  }
  
  public void setSelenoids(boolean mode)
  {
    solenoid1.set(mode);
    solenoid2.set(mode);
    solenoid3.set(mode);
  }  
  
 
  
  @Override
  public void initDefaultCommand() 
  {
    
  }
}
