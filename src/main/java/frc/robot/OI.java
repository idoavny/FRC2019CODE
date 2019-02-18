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
import frc.robot.CommandGroups.PickShoot;
import frc.robot.commands.ElevatorEncoderReset;
//import frc.robot.commands.ForkPiston;
import frc.robot.commands.LImitswitch;
import frc.robot.commands.PID;
import frc.robot.commands.PneomaticCommand;

public class OI 
{
  //              JoySticks
  public Joystick rightJoy = new Joystick(0);
  public Joystick leftJoy = new Joystick(1);
  public Joystick ButtonJoy = new Joystick(2);

  //              Shotter buttons
  Button ShooterButton = new JoystickButton(leftJoy, 2);

//              HatchPanel buttons
Button fork1 = new JoystickButton(ButtonJoy, 1);
Button fork2 = new JoystickButton(ButtonJoy, 2);
Button fork3 = new JoystickButton(ButtonJoy, 3);


  //              Elevator buttons
  Button ElevatorPosition0 = new JoystickButton(rightJoy, 1);
  Button ElevatorPosition2 = new JoystickButton(rightJoy, 2);
  Button ElevatorEncoderReset = new JoystickButton(rightJoy, 6);



  //              Maglol Buttons
  public Button MaglolButton = new JoystickButton(rightJoy, 3);
  public Button MaglolButton2 = new JoystickButton(rightJoy, 4);
  public Button MaglolButton3 = new JoystickButton(rightJoy, 5);
  public Button MaglolButton4 = new JoystickButton(leftJoy, 1);
  public Button MaglolButton5 = new JoystickButton(leftJoy, 2);
  public Button button = new JoystickButton(leftJoy, 3);




public OI()
{
   ElevatorPosition0.whileHeld(new PID(0, false, false));
   ElevatorPosition2.whileHeld(new PID(0, false, true));
   MaglolButton.toggleWhenPressed(new PID(1, true, false));
   MaglolButton2.toggleWhenPressed(new LImitswitch());
   MaglolButton4.toggleWhenPressed(new PickShoot(0, 2));
   MaglolButton5.toggleWhenPressed(new PickShoot(1, 2));
   ElevatorEncoderReset.whenPressed(new ElevatorEncoderReset());
   button.toggleWhenPressed(new PneomaticCommand(true));
  
   

   



//fork1.toggleWhenPressed(new ForkCommad("pick"));
//fork2.toggleWhenPressed(new ForkCommad("release"));
}
}