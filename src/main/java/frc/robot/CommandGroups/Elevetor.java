/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.PID;
import frc.robot.commands.delay;

public class Elevetor extends CommandGroup {

  public Elevetor(String upOrDown) {
    double setPoint = Robot.elevator.EncoderPulses();
    
      switch(upOrDown){
        case "up":
        ++setPoint;
        
        break;
        case "down":
        setPoint = 1000;
       // --setPoint;
        break;
      }
      addParallel(new PID("ball", 0, false, false, setPoint));

      addParallel(new delay(0.3));
      SmartDashboard.putNumber("SetPoint", setPoint);
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