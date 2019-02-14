package frc.robot;

public class Constants {

// JoyStick command constants:
public static int Tankspeed = 0;

// maglol command constants:
public static int fullrange = 0;
public static int offSet = 0;
public static double MagTimeOut = 0.2;
public static double MagSpeed = 0.5;
public static double MagSpeedinterrapted = 0;

// shooter command constants:
public static double ShooterSpeed = 0.5;

// Elevator command constants:
public static double pidMax = 0;
public static double pidMin = 0;
public static double pidWaitTime = 0.2;

// HatchPanel command constants:
 private enum HatchPanel{
    speed(0.8);

    private  double value;
    HatchPanel(double value){
        this.value = value;
    }
    public double Value(){
        return value;
    }
 } 

}