// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static team.gif.robot.RobotMap.*;

public class DriveMotorSystem extends SubsystemBase {

    public SparkMax sparkLeft;
    public SparkMax sparkRight;
    public RelativeEncoder sparkEncoderLeft;
    public RelativeEncoder sparkEncoderRight;
    public DifferentialDrive drive;
    

    public DriveMotorSystem() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(true);
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);

        sparkLeft = new SparkMax(SPARK_MAX_LEFT_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderLeft = sparkLeft.getEncoder();
        sparkLeft.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        sparkRight = new SparkMax(SPARK_MAX_RIGHT_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderRight = sparkRight.getEncoder();
        sparkRight.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        drive = new DifferentialDrive(sparkLeft, sparkRight);
    }

    public void tankDrive(double leftSpeed, double rightSpeed){drive.tankDrive(leftSpeed, rightSpeed);}

    public void arcadeDrive(double moveSpeed, double turnSpeed){drive.arcadeDrive(moveSpeed, turnSpeed);}
}
