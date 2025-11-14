// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.config.RobotConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.estimator.DifferentialDrivePoseEstimator;
import edu.wpi.first.math.estimator.PoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

import static team.gif.robot.Constants.*;


public class DriveMotorSystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public SparkMax sparkleft;
    public SparkMax sparkright;
    public RelativeEncoder sparkEncoderleft;
    public RelativeEncoder sparkEncoderright;
    public DifferentialDrive drive;
    public DifferentialDrivePoseEstimator poseEstimator;
    

    public DriveMotorSystem() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(true);
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);

        sparkleft = new SparkMax(RobotMap.SPARK_MAX_LEFT_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderleft = sparkleft.getEncoder();
        sparkleft.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        sparkright = new SparkMax(RobotMap.SPARK_MAX_RIGHT_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderright = sparkright.getEncoder();
        sparkright.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        drive = new DifferentialDrive(sparkleft, sparkright);

        RobotConfig robotConfig;
        try {
            robotConfig = RobotConfig.fromGUISettings();
        } catch (Exception e) {
            // Handle exception as needed
            e.printStackTrace();
        }

        AutoBuilder.configure(
                this::getPose,


        );
    }

    public Pose2d getPose(){
        return poseEstimator.getEstimatedPosition();
    }

//    public double velocityGetleft(){
//        return  sparkEncoderleft.getVelocity();
//    }
//    public double velocityGetright() {
//
//        return sparkEncoderright.getVelocity();
//    }

    public void setVoltage(double Voltage){
        sparkright.set(Voltage);
        sparkleft.set(Voltage);
    }
    public void tankdrive(double leftspeed, double rightspeed){
        drive.tankDrive(leftspeed, rightspeed);
    }
  /* public void motorvalue(double percentOutputRight, double percentOutputLeft){
        talonleft.set(TalonSRXControlMode.PercentOutput,percentOutputLeft);
        talonright.set(TalonSRXControlMode.PercentOutput, percentOutputRight);
    } */


}
