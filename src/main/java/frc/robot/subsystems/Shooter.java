/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Shooter extends Subsystem 
{
  Solenoid solenoid1 = new Solenoid(1); //TODO: set real solenoid ports
  Solenoid solenoid2 = new Solenoid(2);
  TalonSRX ShooterMotor = new TalonSRX(RobotMap.Shooter_Motor);

  public void setSpeed(double speed)
  {
    ShooterMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setSolenoid(boolean activate)
  {
    if(activate == true) {
      solenoid1.set(true);
      solenoid2.set(true);
    }
    else {
      solenoid1.set(false);
      solenoid2.set(false);
    }
  }

  @Override
  public void initDefaultCommand() 
  {
    
  }
}
