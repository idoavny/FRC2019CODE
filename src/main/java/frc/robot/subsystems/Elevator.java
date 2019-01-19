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
  double Kp;
  double Ki;
  double Kd;

  public Encoder enc = new Encoder(0, 1, false, EncodingType.k1X);

  PIDController pid  = new PIDController(Kp, Ki, Kd, enc,(speed) -> SetSpeed(speed)); 
  DigitalInput LimitSwitch = new DigitalInput(5);
  TalonSRX RightSally = new TalonSRX(1);
  TalonSRX LeftSally = new TalonSRX(2);

  public Elevator()
  {
    enc.setDistancePerPulse(Calculations.MeterPerPulse(4, 200));
    enc.setMinRate(.1);
  }

//            PID Methods             //
  public double setKp(double Kp)
  {
    return this.Kp = Kp;
  }
  
  public double setKi(double Ki)
  {
    return this.Ki = Ki;
  }

  public double setKd(double Kd)
  {
    return this.Kd = Kd;
  }

  public void PIDsetSetpoint(Double setpoint)
  {
    pid.setSetpoint(setpoint);
    
  }

  public void PIDSetAbsoluteTolerance(double tolerance)
  {
    pid.setAbsoluteTolerance(tolerance);
  }
  
  public void PIDReset()
  {
    pid.reset();
  }

  public void PIDEnableOrDisable(boolean Enable)
  {
    if(Enable == true){pid.enable();}
    else{pid.disable();}
  }

  public void PIDsetOutRange(Double max, Double min)
  {
    pid.setOutputRange(min, max);
  }

//            Encoder Methods             //
  public void EncoderReverse (boolean reverse) 
  {
    enc.setReverseDirection(reverse);
  }
  
  public double EncoderDistance()
  {
   return enc.getDistance();
  }

//            Motors Methods             //
  public void SetSpeed (double speed) 
  {
    RightSally.set(ControlMode.PercentOutput,speed);
    LeftSally.set(ControlMode.PercentOutput,speed);
  }

//            LimitSwitch Methods             //
  public boolean limitSwitch() 
  {
    return LimitSwitch.get();
  }

  @Override
  public void initDefaultCommand() 
  {
    
  }
}      