/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Calculations;

public class Elevator extends Subsystem 
{
  private double Kp;
  private double Ki;
  private double Kd;

  public Encoder enc = new Encoder(0, 1, false, EncodingType.k1X);

  private PIDController pid  = new PIDController(Kp, Ki, Kd, enc,(speed) -> SetSpeed(speed)); 
  private DigitalInput LimitSwitch = new DigitalInput(5);
  private TalonSRX RightSally = new TalonSRX(1);
  private TalonSRX LeftSally = new TalonSRX(2);

  public Elevator()
  {
    enc.setDistancePerPulse(Calculations.MeterPerPulse(4, 200));
    enc.setMinRate(.1);
    
  }

//            PID Methods             //
public Double getCurrentPosition()
{
  return enc.getDistance();
}

  public void setKp(double Kp)
  {
    this.Kp = Kp; //setting the kp
  }

  public void setKi(double Ki)
  {
    this.Ki = Ki; //setting the ki
  }

  public void setKd(double Kd)
  {
    this.Kd = Kd; //setting the kd
  }

  public void PIDsetSetpoint(Double setpoint)
  {
    pid.setSetpoint(setpoint); //setting the set point using pid
  }

  public void PIDSetAbsoluteTolerance(double tolerance)
  {
    pid.setAbsoluteTolerance(tolerance); //setting the tolerance using pid
  }
  
  public void PIDReset()
  {
    pid.reset(); //reseting the pid
  }

  public void PIDEnableOrDisable(boolean Enable)
  {
    if(Enable == true) {  //enabling the pid
      pid.enable();
    }
    else { //disabling the pid
      pid.disable();
    }
  }

  public void PIDsetOutRange(Double max, Double min)
  {
    pid.setOutputRange(min, max); //setting the max and min heights for the pid
  }

//            Encoder Methods             //
  public void EncoderReverse (boolean reverse) 
  {
    enc.setReverseDirection(reverse); //checking if need to reverse the encoder direction
  }
  
  public double EncoderDistance()
  {
   return enc.getDistance(); //
  }

//            Motors Methods             //
  public void SetSpeed (double speed) 
  {
    RightSally.set(ControlMode.PercentOutput,speed); //setting right motor speed
    LeftSally.set(ControlMode.PercentOutput,speed); //setting left motor speed
  }

//            LimitSwitch Methods             //
  public boolean limitSwitch() 
  {
    return LimitSwitch.get(); //getting mode from the limit switch
  }

  @Override
  public void initDefaultCommand() 
  {
    
  }
}      