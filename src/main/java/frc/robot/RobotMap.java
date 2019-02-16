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
AnalogIn(7),
MAG_PICK(11),
MAG_ROTATE(9),
MAGLOL_MOTOR(10),
MAGLOL_RIGHT_ROATION(11), 
MAGLOL_LEFT_ROATION(12);

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
HPsolonoid1(7),
Shooter_Motor(13),
HPmotor1(14),
HPmotor2(15),
HPmotor3(16);
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
LimitSwitch(19),
ELEVATOR_LIMIT_SWITCH(20);
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
   solenoidPort(4),
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