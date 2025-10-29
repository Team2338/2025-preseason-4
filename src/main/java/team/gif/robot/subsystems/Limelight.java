// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public Limelight() {}

    //Limelight-name is a placeholder (CHANGE LATER)
    public double getLimelightAngle(){
        return NetworkTableInstance.getDefault().getTable("Limelight-name").getEntry("tx").getDouble(0.0);
    }

    public double getLimelightTY(){
        return NetworkTableInstance.getDefault().getTable("Limelight-name").getEntry("ty").getDouble(0.0);
    }

    public double getLimelightTX(){
        return NetworkTableInstance.getDefault().getTable("Limelight-name").getEntry("tx").getDouble(0.0);
    }

    public  double[] get3DPose(){
        //placeholder and new double[0] are both placeholder (CHANGE LATER)
        return NetworkTableInstance.getDefault().getTable("Limelight-name").getEntry("placeholder").getDoubleArray(new double[0]);
    }

}
