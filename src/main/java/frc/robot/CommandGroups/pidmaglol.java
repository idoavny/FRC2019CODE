/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.PID;

public class pidmaglol extends CommandGroup {
  /**
   * Add your docs here.
   */
  public pidmaglol(String Mode, int level) {
    if(Robot.currentangle < 234 && Robot.currentangle > 230){
      addSequential(new PID(Mode, level, true, false, true));
      addSequential(new MaglolCommand(1, true, true));
      addParallel(new PID(Mode, level, true, false, false));
    }else{
      addParallel(new PID(Mode, level, true, false, false));

    }

  }
}
