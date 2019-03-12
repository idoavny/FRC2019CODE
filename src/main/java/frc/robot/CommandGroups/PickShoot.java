/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.ForkCommad;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.delay;
import frc.robot.commands.maglolPick;

public class PickShoot extends CommandGroup {
  public PickShoot(){
    requires(Robot.fork);
    requires(Robot.maglol);
  }

  public PickShoot(int Mode, double Timer){
    switch(Mode){
      case 0:
      addParallel(new ForkCommad(true, false, 1));
      addParallel(new ForkCommad(false, false, 0.6));
      addParallel(new maglolPick(0.3,false));
      break;
      
      case 1:
      addParallel(new ForkCommad(true, true ,0.7));
      addSequential(new delay(Timer));
      addParallel(new ForkCommad(false, true, 0.5));
      break;

      case 2:
      addParallel(new ForkCommad(true, true ,0.6));
      addSequential(new delay(Timer));
      addParallel(new ForkCommad(false, true, 0.4));
      break;
    }
  }
}