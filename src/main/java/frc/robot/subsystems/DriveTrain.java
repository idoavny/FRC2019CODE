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

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  Encoder encoder = new Encoder(0, 1, false, EncodingType.k1X);
Talon rightMotor1 = new Talon(0);
Talon rightMotor2 = new Talon(1);
SpeedControllerGroup rights = new SpeedControllerGroup(rightMotor1, rightMotor2);

Talon leftMotor1 = new Talon(2);
Talon leftMotor2 = new Talon(3);
SpeedControllerGroup lefts = new SpeedControllerGroup(leftMotor1, leftMotor2);

DifferentialDrive drive = new DifferentialDrive(lefts,rights);

public void setTankSpeed(double RightSpeed, double LeftSpeed){
drive.tankDrive(LeftSpeed, RightSpeed);;
}

  @Override
  public void initDefaultCommand() {

  }
}
