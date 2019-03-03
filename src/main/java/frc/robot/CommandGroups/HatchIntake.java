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
  /**
   * Add your docs here.
   */
  public HatchIntake(int mode) {
     boolean PistonState = false;

    if(mode == 1){
      addSequential(new Solenoids(2, true));
      addSequential(new delay(0.3));
       addSequential(new Solenoids(1, true));
       addSequential(new delay(0.6));
       addSequential(new Solenoids(2, false));
       addSequential(new delay(0.3));
       addSequential(new Solenoids(1, false));
      PistonState= true;
    }
    if(mode == 2){
      addSequential(new Solenoids(1, true));
      addSequential(new delay(0.6));
      addSequential(new Solenoids(2, true));
      addSequential(new delay(0.3));
      addSequential(new Solenoids(1, false));
      addSequential(new delay(0.3));
      addSequential(new Solenoids(2, false));
      PistonState = true;
    }
    SmartDashboard.putBoolean("Pistons State", PistonState);
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
