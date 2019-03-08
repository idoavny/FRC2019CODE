/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Solenoids extends InstantCommand {
  int Solenoid;
  boolean mode;
  
  public Solenoids() {
    super();
    requires(Robot.hatch);

  }
  public Solenoids(int Solenoid, boolean mode) {
    super();
    this.Solenoid = Solenoid;
    this.mode = mode;
    requires(Robot.hatch);
  }
  public Solenoids(Boolean disable) {
    super();
    requires(Robot.hatch);
    //if(disable){Robot.hatch.setSolenoid1(false);
     // Robot.hatch.setSolenoid2(false);}
    

  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if(Solenoid == 1) {
      Robot.hatch.setSolenoid1(mode);
    }
    if(Solenoid == 2) {
      Robot.hatch.setSolenoid2(mode);
    }
  }
  @Override
  protected void end() {
    super.end();
    if(Solenoid == 1) {
      Robot.hatch.setSolenoid1(mode);
    }
    if(Solenoid == 2) {
      Robot.hatch.setSolenoid2(mode);
    }
  }
}