/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.CommandGroups.Elevetor;
import frc.robot.CommandGroups.HatchHook;
import frc.robot.CommandGroups.PickShoot;
import frc.robot.commands.ElevatorEncoderReset;
import frc.robot.commands.ForkCommad;
import frc.robot.commands.HatchSolenoids;
//import frc.robot.commands.ForkPiston;
//import frc.robot.commands.LImitswitch;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.PID;

public class OI 
{
  //              JoySticks
  public Joystick rightJoy = new Joystick(0);
  public Joystick leftJoy = new Joystick(1);
  public Joystick ButtonJoy = new Joystick(2);
  //public POVButton rightPov = new POVButton(rightJoy, 0);

  public double getRightPov(){
    return rightJoy.getPOV();
  }

  //              Shotter buttons
  Button ShooterButton = new JoystickButton(leftJoy, 2);

  //              HatchPanel buttons
  Button fork1 = new JoystickButton(ButtonJoy, 1);
  Button fork2 = new JoystickButton(ButtonJoy, 2);
  Button fork3 = new JoystickButton(ButtonJoy, 3);


  //              Elevator buttons
  Button ElevatorUp = new JoystickButton(ButtonJoy, 5);
  Button ElevatorDown = new JoystickButton(ButtonJoy, 6);
  Button elevatorBallPID0 = new JoystickButton(ButtonJoy, 7);
  Button elevatorBallPID1 = new JoystickButton(ButtonJoy, 8);
  Button elevatorBallPID2 = new JoystickButton(ButtonJoy, 9);
  Button elevatorHatchPID = new JoystickButton(ButtonJoy, 10);
  Button elevatorHatchPID1 = new JoystickButton(ButtonJoy, 11);
  Button elevatorHatchPID2 = new JoystickButton(ButtonJoy, 12);



  //              Maglol Buttons
  public Button forkButton = new JoystickButton(ButtonJoy, 1);
  public Button forkButton2 = new JoystickButton(ButtonJoy, 2);
  public Button MaglolButton1 = new JoystickButton(ButtonJoy, 13);
  public Button MaglolButton2 = new JoystickButton(ButtonJoy, 14);

  //              Fork Buttons

  public Button OpenForkPiston = new JoystickButton(ButtonJoy, 3);
  public Button CloseForkPiston = new JoystickButton(ButtonJoy, 4);

  public OI()
  {
    //ElevatorUp.whileHeld(new Elevetor("up"));
    //ElevatorDown.whileHeld(new Elevetor("down"));
    ElevatorUp.whileHeld(new PID("Ball", 0, false, false, 0));
    ElevatorDown.whileHeld(new PID("Ball", 0, false, true, 0));
    
    elevatorBallPID0.toggleWhenPressed(new PID("Ball",1, true, false,0));
    elevatorBallPID1.toggleWhenPressed(new PID("Ball",2, true, false,0));
    elevatorBallPID2.toggleWhenPressed(new PID("Ball",3, true, false,0));
    elevatorHatchPID.toggleWhenPressed(new PID("Hatch", 1, true, false,0));
    elevatorHatchPID1.toggleWhenPressed(new PID("Hatch", 2, true, false,0));
    elevatorHatchPID2.toggleWhenPressed(new PID("Hatch", 3, true, false,0));

    forkButton.whileHeld(new PickShoot(0, 0.5));
    forkButton2.whileHeld(new PickShoot(1, 1));

    MaglolButton1.whileHeld(new MaglolCommand(false, 0.5, true));
    MaglolButton2.whileHeld(new MaglolCommand(false, 0.5, false));
    
    OpenForkPiston.toggleWhenPressed(new HatchSolenoids("hatchIntake",true));
    CloseForkPiston.toggleWhenPressed(new HatchSolenoids("IntakeUpDown" , true));

    //OpenForkPiston.toggleWhenPressed(new HatchHook("intake"));
    //CloseForkPiston.toggleWhenPressed(new HatchHook("outtake"));



  //fork1.toggleWhenPressed(new ForkCommad("pick"));
  //fork2.toggleWhenPressed(new ForkCommad("release"));
  }
}