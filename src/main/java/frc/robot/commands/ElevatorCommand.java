/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Calculations;
import frc.robot.Robot;
// TODO Put all of thoose numbers in constants!
public class ElevatorCommand extends Command 
{
 private String PortOrHatch;
 private double Setpoint;
 private boolean disable;
 private int mode = 0;
 private double DistancePortsFoot = 2;
 private double DistancePortsInch = 4;
  
  boolean limitswitch = false;

  public ElevatorCommand() 
  {
    requires(Robot.elevator);
  }
  public ElevatorCommand(int mode, String PortOrHatch,String UpOrDown) 
  {
    requires(Robot.elevator);
    this.mode = mode;
    this.PortOrHatch = PortOrHatch;
    if(UpOrDown == "Up"){
      Robot.elevator.setKp(0);
      Robot.elevator.setKi(0);
      Robot.elevator.setKd(0);
    }
    if(UpOrDown == "Down"){
      Robot.elevator.setKp(0);
      Robot.elevator.setKi(0);
      Robot.elevator.setKd(0);
    }
  }
  public ElevatorCommand(boolean disable) 
  {
    requires(Robot.elevator);
    this.disable = disable;
  }

  @Override
  protected void initialize() 
  {
    switch(PortOrHatch){
      case "Port":
        switch(mode) 
        {
          case 1:
          Setpoint = Calculations.FootAndInchToMeter(2, 3.5);
          break;

          case 2:
          Setpoint = Calculations.FootAndInchToMeter(4,7.5);          
          break;

          case 3:
          Setpoint = Calculations.FootAndInchToMeter(6,11.5);
          break;
        }
    break;
      case "Hatch":
        switch(mode) 
        {
          case 1:
          Setpoint = Calculations.FootAndInchToMeter(1, 7);
          break;

          case 2:
          Setpoint = Calculations.FootAndInchToMeter(3,11);          
          break;

          case 3:
          Setpoint = Calculations.FootAndInchToMeter(6,3);
          break;
        }
    break;
    }
    Robot.elevator.PIDsetSetpoint(Setpoint);
  }
  @Override
  protected void execute() 
  {
    limitswitch = Robot.elevator.limitSwitch();
    if( limitswitch == true) 
    {
      Robot.elevator.SetSpeed(0);
      Robot.elevator.PIDsetSetpoint(0.);
      Robot.elevator.enc.reset();
    }
    Robot.elevator.PIDEnableOrDisable(true);
  }

  @Override
  protected boolean isFinished() 
  {
    return disable;
  }

  @Override
  protected void end() 
  {
    while(Setpoint > 0)
    Robot.elevator.SetSpeed(-0.4);
  }

  @Override
  protected void interrupted() 
  {
    Robot.elevator.SetSpeed(0);
  }
}
