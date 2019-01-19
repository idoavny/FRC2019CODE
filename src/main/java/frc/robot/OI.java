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
import frc.robot.commands.HatchCommad;
import frc.robot.commands.MaglolCommand;
import frc.robot.commands.ShooterCommand;

public class OI 
{
//              JoySticks
  public Joystick rightJoy = new Joystick(0);
  public Joystick leftJoy = new Joystick(1);
  public Joystick ButtonJoy = new Joystick(2);

//              Shotter buttons
Button ShooterButtonForword = new JoystickButton(leftJoy, 2);
Button ShooterButtonReverse = new JoystickButton(leftJoy, 3);

//              HatchPanel buttons
Button BButton1 = new JoystickButton(ButtonJoy, 1);
Button BButton2 = new JoystickButton(ButtonJoy, 2);
Button BButton3 = new JoystickButton(ButtonJoy, 3);


//              Elevator buttons
Button ElevatorPosition0 = new JoystickButton(rightJoy, 1);


//              Maglol Buttons
Button MaglolForword = new JoystickButton(rightJoy, 2);
Button MaglolReverse = new JoystickButton(rightJoy, 3);

public OI()
{
ElevatorPosition0.whenPressed(new ElevatorCommand(1, "Port", "UP"));
MaglolForword.whileHeld(new MaglolCommand(false));
MaglolReverse.whileHeld(new MaglolCommand(true));
ShooterButtonForword.whileHeld(new ShooterCommand(false));
ShooterButtonReverse.whileHeld(new ShooterCommand(true));
BButton1.whenPressed(new HatchCommad(1));
BButton2.whenPressed(new HatchCommad(2));
BButton3.whenPressed(new HatchCommad(3));
}
}