/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.JoyStickCommand;


public class DriveTrain extends Subsystem 
{
  private Encoder encoder = new Encoder(2, 3, false, EncodingType.k1X);
  private Talon rightMotor1 = new Talon(RobotMap.RightMotor);
  private Talon rightMotor2 = new Talon(RobotMap.RearRightMotor);
  private SpeedControllerGroup rights = new SpeedControllerGroup(rightMotor1, rightMotor2);
  
  private Talon leftMotor1 = new Talon(RobotMap.LeftMotor);
  private Talon leftMotor2 = new Talon(RobotMap.RearLeftMotor);
  private SpeedControllerGroup lefts = new SpeedControllerGroup(leftMotor1, leftMotor2);
  
  private DifferentialDrive drive = new DifferentialDrive(lefts,rights);
  //DifferentialDrive drive = new DifferentialDrive(leftMotor1,rightMotor1);
  
  public DriveTrain()
  {
    drive.setDeadband(0);
    
  }


  public void setTankSpeed(double RightSpeed, double LeftSpeed)
  {
  drive.tankDrive(LeftSpeed, RightSpeed);;
  }

  @Override
  public void initDefaultCommand()
  {
    setDefaultCommand(new JoyStickCommand());
  }
}
