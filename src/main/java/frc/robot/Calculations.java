/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Timer;

/**
 * Add your docs here.
 */
public class Calculations
{
    public static double MeterPerPulse(int WheelDIameter, int EncoderResolution)
    {
        return(((WheelDIameter*Math.PI*2.54)/100)/EncoderResolution); //calculating the number of pulses for 1 motor rotation
    }

    public static double FootAndInchToMeter(int Foot, double Inch)
    {
        return (((Foot*12)+Inch)*2.54)/100; //switching from foot and inches to meters
    }


}
