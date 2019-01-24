/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Calculations;
import frc.robot.Constants;
import frc.robot.Robot;
//TODO Put all of thoose numbers in constants!
public class ElevatorCommand extends Command 
{
  private String PortOrHatch;
  private double Setpoint;
  private boolean disable;
  private int mode = 0;
  private double currentPosition;
  boolean limitswitch = false;

  public ElevatorCommand() 
  {
    requires(Robot.elevator);
  }
  public ElevatorCommand(int mode, String PortOrHatch) 
  {
    requires(Robot.elevator);
    this.PortOrHatch = PortOrHatch; //setting port or hatch (depended on the situation)
    this.mode = mode; //setting the port/hatch mode
  }

  public ElevatorCommand(boolean disable) 
  {
    requires(Robot.elevator);
    this.disable = disable; //getting disable value from constructor
  }

  @Override
  protected void initialize() 
  {
    if(Robot.elevator.EncoderDistance() > currentPosition) {
      Robot.elevator.setKp(Constants.KpUp); // {
      Robot.elevator.setKi(Constants.KiUp); //   setting pid when the elevator goes up
      Robot.elevator.setKd(Constants.KdUp); // }
    }
    else {
      Robot.elevator.setKp(Constants.KpDown); // {
      Robot.elevator.setKi(Constants.KiDown); //   setting pid when the elevator goes down
      Robot.elevator.setKd(Constants.KdDown);// }
    }

    switch(PortOrHatch) {
      case "Port":
        switch(mode) 
        {
          case 1:
          Setpoint = Calculations.FootAndInchToMeter(2, 3.5); //setting set point for the first ball port
          break;

          case 2:
          Setpoint = Calculations.FootAndInchToMeter(4,7.5); //setting set point for the middle ball port
          break;

          case 3:
          Setpoint = Calculations.FootAndInchToMeter(6,11.5); //setting set point for the last ball port
          break;
        }
    break;

      case "Hatch":
        switch(mode) 
        {
          case 1:
          Setpoint = Calculations.FootAndInchToMeter(1, 7); //setting set point for the first hatch port
          break;

          case 2:
          Setpoint = Calculations.FootAndInchToMeter(3,11); //setting set point for the middle hatch port
          break;

          case 3:
          Setpoint = Calculations.FootAndInchToMeter(6,3); //setting set point for the last hatch port
          break;
        }
    break;
    }

    Robot.elevator.PIDsetSetpoint(Setpoint); //using pid to reach the desirable set point
  }
  @Override
  protected void execute() 
  {
    
    limitswitch = Robot.elevator.limitSwitch(); //checking limit switch mode
    if(limitswitch == true) { //if the limit switch is clicked, stop the motors
      Robot.elevator.SetSpeed(0);
      Robot.elevator.PIDsetSetpoint(0.0);
      Robot.elevator.enc.reset();
    }
    Robot.elevator.PIDEnableOrDisable(true);
  }

  @Override
  protected boolean isFinished() 
  {
    return disable; //returning disable
  }

  @Override
  protected void end() 
  {
    while(Setpoint > 0) //at the end of
    {
      Robot.elevator.SetSpeed(-0.4);

    }
  }

  @Override
  protected void interrupted() 
  {
    Robot.elevator.SetSpeed(0); //if the elevator is interrupted, stop it's motion
  }
}
