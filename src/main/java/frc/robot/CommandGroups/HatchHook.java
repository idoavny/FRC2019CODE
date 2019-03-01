/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.HatchSolenoids;
import frc.robot.commands.delay;

public class HatchHook extends CommandGroup {
  
  public HatchHook(String Mode) {
    
    switch(Mode){
      case "intake":
      addParallel(new HatchSolenoids("IntakeUpDown", true));
      addSequential(new delay(0.2));
      addParallel(new HatchSolenoids("hatchIntake",true));
      addSequential(new delay(0.5));
      addParallel(new HatchSolenoids("IntakeUpDown", false));
      addSequential(new delay(0.5));
      addParallel(new HatchSolenoids("hatchIntake", false));
      break;

      case "outtake":
      addParallel(new HatchSolenoids("hatchIntake",true));
      addSequential(new delay(0.5));
      addParallel(new HatchSolenoids("IntakeUpDown", true));
      addSequential(new delay(0.5));
      addParallel(new HatchSolenoids("hatchIntake", false));
      break;
    }
  }
}