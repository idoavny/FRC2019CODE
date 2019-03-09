/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.CommandGroups.BallFeederIntake;
import frc.robot.CommandGroups.HatchIntake;
import frc.robot.CommandGroups.PickShoot;
import frc.robot.commands.ElevatorEncoderReset;
import frc.robot.commands.ForkCommad;
import frc.robot.commands.LImitswitch;
//import frc.robot.commands.ForkPiston;
//import frc.robot.commands.LImitswitch;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.PID;
import frc.robot.commands.Solenoids;

public class OI 
{
  //              JoySticks
  public XboxController xbox = new XboxController(2);
  public Joystick rightJoy = new Joystick(0);
  public Joystick leftJoy = new Joystick(1);
  public Joystick ButtonJoy = new Joystick(2);
  //public POVButton rightPov = new POVButton(rightJoy, 0);

  public double getRightPov(){
    return rightJoy.getPOV();
  }
  //              XboxButtons

  //              Shotter buttons
  Button ShooterButton = new JoystickButton(leftJoy, 2);

  //              HatchPanel buttons
  Button fork1 = new JoystickButton(ButtonJoy, 1);
  Button fork2 = new JoystickButton(ButtonJoy, 2);
  Button fork3 = new JoystickButton(ButtonJoy, 3);


  //              Elevator buttons
  
  POVButton elevatorUp1 = new POVButton(ButtonJoy, 0);
  POVButton elevatorUp2 = new POVButton(ButtonJoy, 45);
  POVButton elevatorUp3 = new POVButton(ButtonJoy, 315);
  POVButton elevatorDown1 = new POVButton(ButtonJoy, 180);
  POVButton elevatorDown2 = new POVButton(ButtonJoy, 135);
  POVButton elevatorDown3 = new POVButton(ButtonJoy, 225);

 
  Button elevatorBallPID0 = new JoystickButton(ButtonJoy, 5);
  Button elevatorBallPID1 = new JoystickButton(ButtonJoy, 6);
  Button elevatorBallPID2 = new JoystickButton(ButtonJoy, 7);
  Button elevatorHatchPID = new JoystickButton(ButtonJoy, 8);
  Button elevatorHatchPID1 = new JoystickButton(ButtonJoy, 9);
  Button elevatorHatchPID2 = new JoystickButton(ButtonJoy, 10);



  //              Maglol Buttons
  public Button forkButton = new JoystickButton(ButtonJoy, 1);
  public Button forkButton2 = new JoystickButton(ButtonJoy, 2);
  public Button MaglolButton1 = new JoystickButton(ButtonJoy, 13);
  public Button MaglolButton2 = new JoystickButton(ButtonJoy, 14);

  //              Fork Buttons
  Button FeederIntake = new JoystickButton(leftJoy, 2);
  public Button OpenForkPiston = new JoystickButton(ButtonJoy, 3);
  public Button CloseForkPiston = new JoystickButton(ButtonJoy, 4);
//public Button closeSolenoids = new JoystickButton(rightJoy, 4);

  public OI()
  {
    SmartDashboard.putBoolean("A", xbox.getAButton());
    SmartDashboard.putBoolean("X", xbox.getXButton());
    SmartDashboard.putBoolean("B", xbox.getBButton());
    SmartDashboard.putBoolean("Y", xbox.getYButton());
    SmartDashboard.putBoolean("BumperRight", xbox.getBumper(Hand.kRight));
    SmartDashboard.putBoolean("BumperLeft", xbox.getBumper(Hand.kLeft));
    SmartDashboard.putNumber("GetTriggerLeft", xbox.getTriggerAxis(Hand.kLeft));
    SmartDashboard.putNumber("GetTriggerRight", xbox.getTriggerAxis(Hand.kRight));
    SmartDashboard.putNumber("getRightY", xbox.getY(Hand.kRight));
    SmartDashboard.putNumber("getLefttY", xbox.getY(Hand.kLeft));

   // closeSolenoids.toggleWhenPressed(new Solenoids(true));
    elevatorUp1.whileHeld(new PID("Ball",0  ,false, false));
    elevatorUp2.whileHeld(new PID("Ball",0 , false, false));
    elevatorUp3.whileHeld(new PID("Ball", 0, false, false));
    elevatorDown1.whileHeld(new PID("Ball",0,  false, true));
    elevatorDown2.whileHeld(new PID("Ball",0,  false, true));
    elevatorDown3.whileHeld(new PID("Ball",0,  false, true));
    
    elevatorBallPID0.toggleWhenActive(new PID("Ball",1, true,false));
    elevatorBallPID1.toggleWhenActive(new PID("Ball",2, true, false));
    elevatorBallPID2.toggleWhenActive(new PID("Feeder",1,true,false));
    //elevatorBallPID2.toggleWhenActive(new PID("Ball",3, true, false));
    elevatorHatchPID.toggleWhenActive(new PID("Hatch",3, true, false));
    elevatorHatchPID1.toggleWhenActive(new PID("Hatch",2, true, false));
    elevatorHatchPID2.toggleWhenActive(new LImitswitch());

    forkButton.whileHeld(new PickShoot(0, 0.5));
    forkButton2.whileHeld(new PickShoot(1, 0.5));

    MaglolButton1.whileHeld(new MaglolCommand(false, 0.5, true));
    MaglolButton2.whileHeld(new MaglolCommand(false, 0.5, false));
    
    OpenForkPiston.toggleWhenPressed(new HatchIntake(1));
    CloseForkPiston.toggleWhenPressed(new HatchIntake(2));
    FeederIntake.whileHeld(new BallFeederIntake());
  }

  }
