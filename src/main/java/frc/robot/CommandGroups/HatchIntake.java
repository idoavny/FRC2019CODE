/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Solenoids;
import frc.robot.commands.delay;

public class HatchIntake extends CommandGroup {

  public HatchIntake(int mode) {

    if(mode == 1){
      addSequential(new Solenoids(2, true));
      addSequential(new delay(0.3));
       addSequential(new Solenoids(1, true));
       addSequential(new delay(0.6));
       addSequential(new Solenoids(2, false));
       addSequential(new delay(0.3));
       addSequential(new Solenoids(1, false));
    }

    if(mode == 2){
      addSequential(new Solenoids(1, true));
      addSequential(new delay(0.6));
      addSequential(new Solenoids(2, true));
      addSequential(new delay(0.3));
      addSequential(new Solenoids(1, false));
      addSequential(new delay(0.3));
      addSequential(new Solenoids(2, false));
    }
  }
}
