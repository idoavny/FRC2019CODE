package frc.robot;

public class Constants {

    // JoyStick command constants:
    public static int ZeroSpeed = 0;

// maglol command constants:
public static int fullrange = 360;
public static int offSet = 0;
public static double MagTimeOut = 0.2;
public static double MagSpeed = 0.6;
public static double MagSpeedinterrapted = 0;

    // shooter command constants:
    public static double ShooterSpeed = 0.5;
    // fork command constants:
    public enum Fork{
        forklimitswitch(30);
    
        private double value;
        Fork(double value){
            this.value = value;
        }
        public double Value(){
            return value;
        }
     } 
// Elevator command constants:
public enum PIDconstants{
    P(10),
    I(0.005),
    D(0.00);

    private double value;
    PIDconstants(double value){
        this.value = value;
    }
    public double Value(){
        return value;
    }
 } 
}
