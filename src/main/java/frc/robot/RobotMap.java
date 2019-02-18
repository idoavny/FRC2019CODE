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
public enum Joysticks
{
MaglolForwordButton(16),
MaglolReverseButton(17),
LeftJoystick(1),
RightJoystick(0);
private int value;
 Joysticks(int value)
 {
    this.value = value;
 }
 public int  getValue()
 {
    return value;
 }
}
   //              Drive
public enum Drive
{

RightMotor1(12),
RightMotor2(20),
rightMotor3(30),
LeftMotor1(10),
LeftMotor2(15),
LeftMotor3(17);
private int value;
 Drive(int value)
 {
    this.value = value;
 }
 public int  getValue()
 {
    return value;
 }
}
   //              Maglol
public enum Maglol
{
//AnalogIn(6),
MAG_PICK(11),
MAG_ROTATE(9),
MAGLOL_MOTOR(10),
MAGLOL_RIGHT_ROATION(3), 
MAGLOL_LEFT_ROATION(4);

private int value;
 Maglol(int value)
 {
    this.value = value;
 }
 public int  getValue()
 {
    return value;
 }
}

public enum Fork
{
HPsolonoid1(4),
Shooter_Motor(13),
HPmotor1(2),
HPmotor2(0),
HPmotor3(1);
//public static int HPpotentiometer = 5;

private int value;
 Fork(int value)
 {
    this.value = value;
 }
 public int  getValue()
 {
    return value;
 }
}

public enum Elevator
{
//              Elevator
ElevatorRight(42),
ElevatorLeft(19),
ELEVATOR_LIMIT_SWITCH(6),
ELEVATOR_LIMIT_SWITCH2(2);
private int value;
 Elevator(int value)
 {
    this.value = value;
 }
 public int  getValue()
 {
    return value;
 }
}

//              HatchPanel
public enum HatchPanel{
   solenoidPort(5),
   TalonPWM(19);
   private int value;
   HatchPanel(int value){
       this.value = value;
   }
   public int getValue(){
      return value;
   }
}
}