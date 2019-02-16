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
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.ForkCommad;
import frc.robot.commands.MaglolCommand;

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


  //              Maglol Buttons
  Button MaglolButton = new JoystickButton(rightJoy, 3);
  Button MaglolButton2 = new JoystickButton(rightJoy, 4);

public OI()
{
  ElevatorPosition0.whileHeld(new ElevatorCommand(false, false, 0));
  ElevatorPosition2.whileHeld(new ElevatorCommand(false, true, 0));
MaglolButton.whileHeld(new MaglolCommand(true, false, 0));
MaglolButton2.whileHeld(new MaglolCommand(true, true, 0));

fork1.toggleWhenPressed(new ForkCommad("pick"));
fork2.toggleWhenPressed(new ForkCommad("release"));
}
}