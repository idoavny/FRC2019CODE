/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.Encoder;

//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.JoyStickCommand;


public class DriveTrain extends Subsystem 
{
  // private Encoder encoder = new Encoder(2, 3, false, EncodingType.k1X);
  private TalonSRX rightMotor1 = new  TalonSRX(RobotMap.Drive.RightMotor1.getValue());
  private  TalonSRX rightMotor2 = new  TalonSRX(RobotMap.Drive.RightMotor2.getValue());
  private  TalonSRX rightMotor3 = new  TalonSRX(RobotMap.Drive.rightMotor3.getValue());
  //private SpeedControllerGroup rights = new SpeedControllerGroup(rightMotor1, rightMotor2, rightMotor3);
  
  private  TalonSRX leftMotor1 = new  TalonSRX(RobotMap.Drive.LeftMotor1.getValue());
  private  TalonSRX leftMotor2 = new  TalonSRX(RobotMap.Drive.LeftMotor2.getValue());
  private  TalonSRX leftMotor3 = new  TalonSRX(RobotMap.Drive.LeftMotor3.getValue());
  //private SpeedControllerGroup lefts = new SpeedControllerGroup(leftMotor1, leftMotor2, leftMotor3);
  
  //private DifferentialDrive drive = new DifferentialDrive(lefts,rights);
  //DifferentialDrive drive = new DifferentialDrive(leftMotor1,rightMotor1);
  
 /* public DriveTrain()
  {
    drive.setDeadband(0);
  }*/


  public void setTankSpeed(double RightSpeed, double LeftSpeed)
  {
    rightMotor1.set(ControlMode.PercentOutput, -RightSpeed);
    rightMotor2.set(ControlMode.PercentOutput, -RightSpeed);
    rightMotor3.set(ControlMode.PercentOutput, -RightSpeed);
    leftMotor1.set(ControlMode.PercentOutput, -LeftSpeed);
    leftMotor2.set(ControlMode.PercentOutput, -LeftSpeed);
    leftMotor3.set(ControlMode.PercentOutput, -LeftSpeed);
  }

  @Override
  public void initDefaultCommand()
  {
    setDefaultCommand(new JoyStickCommand());
  }
}