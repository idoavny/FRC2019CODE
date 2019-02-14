/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Calculations;
import frc.robot.RobotMap;

public class Elevator extends Subsystem 
{
  private double Kp;
  private double Ki;
  private double Kd;

  public Encoder enc = new Encoder(0, 1, false, EncodingType.k1X);

  public PIDController pid  = new PIDController(Kp, Ki, Kd, enc,(speed) -> SetSpeed(speed)); 
  private DigitalInput LimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH);
  private VictorSPX RightMotor = new VictorSPX(1);
  private VictorSPX LeftMotor = new VictorSPX(2);

  public Elevator()
  {
    enc.setPIDSourceType(PIDSourceType.kDisplacement);
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

  public void PIDsetSetpoint(int setpoint)
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

  public double EncoderPulses(){
    return enc.get();
  }

//            Motors Methods             //
  public void SetSpeed (double speed) 
  {
    RightMotor.set(ControlMode.PercentOutput,speed);
    LeftMotor.set(ControlMode.PercentOutput,speed);
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