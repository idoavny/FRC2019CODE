/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.LImitswitch;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.PID;

public class MaglolAutomation extends CommandGroup {
  /**
   * Add your docs here.
   */
  public MaglolAutomation(boolean open) {
    requires(Robot.elevator);
    requires(Robot.maglol);
    if(open){
      addSequential(new PID("Hatch", 2, true, false, true));
      addSequential(new MaglolCommand(1, true, true));
    //  addSequential(new LImitswitch());
    }else{
      addSequential(new PID("Hatch", 2, true, false, true));
      addSequential(new MaglolCommand(2, true, true));
     // addSequential(new LImitswitch());
    }
  }
    
  }
