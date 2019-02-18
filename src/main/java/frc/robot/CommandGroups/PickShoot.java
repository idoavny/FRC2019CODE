/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Counter.Mode;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.ForkCommad;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.delay;

public class PickShoot extends CommandGroup {
  /**
   * Add your docs here.
   */
  private int Mode;
  private int Timer;

  public PickShoot(){
    requires(Robot.fork);
    requires(Robot.maglol);
  }

  public PickShoot(int Mode,int Timer){
    this.Mode = Mode;
    this.Timer = Timer;
    switch(Mode){
      case 0:
      addParallel(new MaglolCommand(true, 0.35, true));
      addParallel(new ForkCommad(true, true, 0.7));
      addParallel(new ForkCommad(false, false, 0.6));
      break;
      
      case 1:
      addParallel(new ForkCommad(true, false ,0.7));
      addSequential(new delay(Timer));
      addParallel(new ForkCommad(false, true, 0.5));
      //addParallel(new ForkCommad(true, false, 0.9));

      break;
    }
 
   
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
