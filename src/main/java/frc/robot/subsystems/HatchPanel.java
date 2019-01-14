/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchPanel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Solenoid solenoid1 = new Solenoid(RobotMap.HPsolonoid1);
  Solenoid solenoid2 = new Solenoid(RobotMap.HPsolonoid2);
  Solenoid solenoid3 = new Solenoid(RobotMap.HPsolonoid3);
  public void SetSelenoids(boolean mode,int num)
  {
  switch(num)
    {
    case 1:solenoid1.set(mode);   //one time
    break;
    case 2:solenoid1.set(mode); solenoid2.set(mode); //two times
    break;
    case 3:solenoid1.set(mode); solenoid2.set(mode); solenoid1.set(mode); //three times
    break;
    }  
  }
 
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
