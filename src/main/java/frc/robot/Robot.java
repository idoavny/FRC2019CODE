/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomusCommand;
import frc.robot.subsystems.Autonomus;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Fork;
import frc.robot.subsystems.Hatchpanel;
import frc.robot.subsystems.Maglol;
//testing branches
public class Robot extends TimedRobot 
{
  public static Autonomus m_subsystem = new Autonomus();
  public static OI m_oi;
  public static Maglol maglol;
  public static DriveTrain drive;
  public static Fork fork;
  public AHRS navxTesting;
  public static Elevator elevator;
  public static Hatchpanel hatchpanel;


  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() 
  {
    navxTesting = new AHRS(SPI.Port.kMXP);
    hatchpanel = new Hatchpanel();
    drive = new DriveTrain();
    fork = new Fork();
    maglol = new Maglol();
    elevator  = new Elevator();
    // CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();
    m_oi = new OI();


    m_chooser.setDefaultOption("Default Auto", new AutonomusCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

  }


  @Override
  public void robotPeriodic()
  {
    SmartDashboard.putNumber("Elevator pid", Robot.elevator.pid.getError());
    SmartDashboard.putNumber("Elevator Encoder", elevator.EncoderPulses());
  }

 
  @Override
  public void disabledInit()
  {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() 
  {
    m_autonomousCommand = m_chooser.getSelected();

    if(m_autonomousCommand != null) 
    {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() 
  {
    
  }
}