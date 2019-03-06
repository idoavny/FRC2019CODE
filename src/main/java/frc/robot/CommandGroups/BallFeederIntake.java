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

public class BallFeederIntake extends CommandGroup {
  
  public BallFeederIntake() {
    requires(Robot.fork);
    addParallel(new ForkCommad(true, true, 1));
    addParallel(new ForkCommad(false, false, 0.6));
  }
}
