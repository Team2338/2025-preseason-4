// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveMotorSystem extends SubsystemBase {

    public WPI_TalonSRX TalonRight;
    public WPI_TalonSRX TalonLeft;
    public DifferentialDrive drive;

    public DriveMotorSystem() {
        TalonLeft = new WPI_TalonSRX(31);
        TalonRight = new WPI_TalonSRX(28);
        drive = new DifferentialDrive(TalonLeft, TalonRight);
    }
    public void arcadeDrive(double moveSpeed, double turnSpeed){drive.arcadeDrive(moveSpeed,-turnSpeed*.5);}
}
