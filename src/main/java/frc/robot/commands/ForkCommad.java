/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;




import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ForkCommad extends Command {
  private boolean Shoot;
  private double speed;
  private boolean isReverse;

  public ForkCommad() {
    requires(Robot.fork);
  }
  public ForkCommad(int timeOut, boolean Shoot,boolean isReverse,double speed){
    setTimeout(2);
    this.Shoot = Shoot;
    this.isReverse = isReverse;
    this.speed = speed;
  }
  public ForkCommad(boolean Shoot, boolean isReverse, double speed)
  {
    this.Shoot = Shoot;
    this.isReverse = isReverse;
    this.speed = speed;
  }

  @Override
  protected void initialize() 
  {

  }

  @Override
  protected void execute() 
  {
    if(Shoot){
      Robot.fork.setShootSpeed(speed, isReverse);
    }
    else{
      Robot.fork.setOutSpeed(speed, isReverse);
    }
  
  }
  @Override
  protected boolean isFinished() 
  {
    return isTimedOut();
  }

  @Override
  protected void end() 
  {
    Robot.fork.setShootSpeed(0, false);

  }

  @Override
  protected void interrupted() 
  {
    Robot.fork.setShootSpeed(0.0,true);
    Robot.fork.setOutSpeed(0.0, true);
  }
}