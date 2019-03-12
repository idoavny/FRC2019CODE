/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.CommandGroups.HatchIntake;
import frc.robot.CommandGroups.MaglolAutomation;
import frc.robot.commands.AutonomusCommand;
import frc.robot.commands.ElevatorEncoderReset;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.PID;
import frc.robot.subsystems.Autonomus;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Fork;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.Maglol;
//testing branches
public class Robot extends TimedRobot 
{
  public static PID pid;
public double kp ;
  public double ki;
  public double kd;
  public double downKp;
  public double downKi;
  public double downKd;
  public int  Level = 0;

  public static Autonomus m_subsystem = new Autonomus();
  public static OI m_oi;
  public static Maglol maglol;
  public static DriveTrain drive;
  public static Fork fork;
  public AHRS navxTesting;
  public static Elevator elevator;
  public Preferences pref;
  public static Compressor comp;
  public static DigitalInput LimitSwitch;
  public static DigitalInput LimitSwitch2;
  public static boolean intakeFlag = false;
  public static Hatch hatch;
  public static HatchIntake hatchintake;
  public boolean prevTrigger;
  public static MaglolCommand maglolCommand;
  public static double currentangle;
  public static 
  UsbCamera camera;
  UsbCamera camera2;
  VideoSink server;
  VideoSink server2;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() 
  {
   
    camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera = CameraServer.getInstance().startAutomaticCapture(0);

    server = CameraServer.getInstance().getServer();
    comp = new Compressor();
    comp.setClosedLoopControl(true);
    navxTesting = new AHRS(SPI.Port.kMXP);
    drive = new DriveTrain();
    fork = new Fork();
    maglol = new Maglol();
    maglolCommand = new MaglolCommand();

    elevator  = new Elevator();
    pid = new PID();
    hatch = new Hatch();

    // CameraServer.getInstance().startAutomaticCapture();
    m_oi = new OI();
    elevator.EncoderReset();
    hatch.solenoid1.clearAllPCMStickyFaults();
    hatch.solenoid2.clearAllPCMStickyFaults();


    m_chooser.setDefaultOption("Default Auto", new AutonomusCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    comp.clearAllPCMStickyFaults();
  }

  @Override
  public void robotPeriodic()
  {
    //maglol.setPickSpeed(0.9, true);
  SmartDashboard.putNumber("PickValue", maglol.pickMotor.getMotorOutputPercent());
   currentangle = maglol.PotentiometerValue();
     // if(m_oi.ButtonJoy.getY() < -0.7){
      //MaglolCommand maglolcommand = new MaglolCommand(1, false, true);
      //maglolcommand.start();
     // }
  /* if(m_oi.ButtonJoy.getY() > 0.7){
      MaglolCommand maglolcommand = new MaglolCommand(2, true, true);
      maglolcommand.start();
    }*/
    SmartDashboard.putNumber("currentAngle",maglol.PotentiometerValue());

    //SmartDashboard.putNumber("Potentiometer",Robot.maglol.PotentiometerValue());
    SmartDashboard.putBoolean("RightJoy", Robot.m_oi.rightJoy.getRawButton(2));
    SmartDashboard.putNumber("Leftjoy", Robot.m_oi.leftJoy.getY());
    SmartDashboard.putBoolean("LimitSwitch", Robot.elevator.LimitSwitch.get());
    SmartDashboard.putBoolean("LimitSwitch2", Robot.elevator.LimitSwitch2.get());
    SmartDashboard.putData("EncoderReset", new ElevatorEncoderReset());
    SmartDashboard.putNumber("ElevatorEncoder", Robot.elevator.enc.get());
  }

  @Override
  public void disabledInit()
  {
    Robot.pid.count = 0;
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
    SmartDashboard.putBoolean("Low Pressure", comp.getPressureSwitchValue());
      prevTrigger = false;
  }

  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
    if(m_oi.leftJoy.getTrigger()){
      prevTrigger = !prevTrigger;
    }
    if(!prevTrigger){
      
      server.setSource(camera);
    }
    else{
      server.setSource(camera2);
    }
  }


  @Override
  public void testPeriodic() 
  {
    
  }
}