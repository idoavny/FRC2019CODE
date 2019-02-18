/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem 
{
  private double kp;
  private double ki;
  private double kd;

  public Encoder enc = new Encoder(8, 9, false, EncodingType.k1X);
  public  PIDController pid  = new PIDController(kp, ki, kd, enc, (speed) -> SetSpeed(speed));

  private DigitalInput LimitSwitch = new DigitalInput(RobotMap.Elevator.ELEVATOR_LIMIT_SWITCH.getValue());
  private DigitalInput LimitSwitch2 = new DigitalInput(RobotMap.Elevator.ELEVATOR_LIMIT_SWITCH2.getValue());

  private VictorSPX RightMotor = new VictorSPX(RobotMap.Elevator.ElevatorRight.getValue());
  private VictorSPX LeftMotor = new VictorSPX(RobotMap.Elevator.ElevatorLeft.getValue());

  public Elevator()
  {
    RightMotor.setInverted(true);
    enc.setPIDSourceType(PIDSourceType.kDisplacement);
    enc.setMinRate(.1);
  }

//            PID Methods             //
public Double getCurrentPosition()
{
  return enc.getDistance();
}

  public void setKp(double kp)
  {
    this.kp = kp; //setting the kp
  }

  public void setKi(double ki)
  {
    this.ki = ki; //setting the ki
  }

  public void setKd(double kd)
  {
    this.kd = kd; //setting the kd
  }

  public void PIDsetSetpoint(int setpoint)
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
  public void EncoderReverse(boolean reverse) 
  {
    enc.setReverseDirection(reverse); //checking if need to reverse the encoder direction
  }

  public double EncoderPulses(){
    return enc.get();
  }

  public void EncoderReset(){
     enc.reset();
  }

//            Motors Methods             //
  public void SetSpeed (double speed) 
  {
    RightMotor.set(ControlMode.PercentOutput,speed);
    LeftMotor.set(ControlMode.PercentOutput,-speed);
  }

//            LimitSwitch Methods             //
  public boolean limitSwitch() 
  {
    return LimitSwitch.get(); //getting mode from the limit switch
  }

  public boolean limitSwitch2() 
  {
    return LimitSwitch2.get(); //getting mode from the limit switch
  }

  @Override
  public void initDefaultCommand() 
  {
    
  }
}      