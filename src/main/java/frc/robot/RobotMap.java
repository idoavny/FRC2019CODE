/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
    //comment

//              Joysticks
public static int LJoyport = 1;
public static int RJoyport = 2;

//              Drive
public static int RightMotor = 3;
public static int RearRightMotor = 1;
public static int LeftMotor = 2;
public static int RearLeftMotor = 0;

//              Maglol
public static int AnalogIn = 0;
public static final int MAG_PICK = 0;
public static final int MAG_ROTATE = 1;
public static int MAGLOL_MOTOR = 4;
public static int MAGLOL_RIGHT_ROATION = 4; //TODO: put the real ports for the maglol rotation motors
public static int MAGLOL_LEFT_ROATION = 4;
//              Shooter
public static int Shooter_Motor = 5; 

//              HatchPanel
public static int HPsolonoid1 = 0;

//public static int HPpotentiometer = 5;
public static int HPmotor1 = 0;
public static int HPmotor2 = 1;
public static int HPmotor3 = 2;
//              Right JoyStick Buttons
public static int MaglolForwordButton = 2;
public static int MaglolReverseButton = 3;

//              Left JoyStick Buttons


//              Elevator
public static int ElevatorRight = 1;
public static int ElevatorLeft = 2;
public static int LimitSwitch = 1;
public static int ELEVATOR_LIMIT_SWITCH = 9;
}