// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.config.RobotConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.estimator.DifferentialDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

import static team.gif.robot.RobotMap.SPARK_MAX_ID;

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

        sparkleft = new SparkMax(SPARK_MAX_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderleft = sparkleft.getEncoder();
        sparkleft.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        sparkright = new SparkMax(SPARK_MAX_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderright = sparkright.getEncoder();
        sparkright.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);


        drive = new DifferentialDrive(sparkleft, sparkright);

 //      RobotConfig robotConfig;
 //       try {
 //           robotConfig = RobotConfig.fromGUISettings();
 //       } catch (Exception e) {
 //           // Handle exception as needed
 //           e.printStackTrace();
 //       }


  //      AutoBuilder.configure(
    //            this::getPose,
      //          this:: resetPose,
        //        this:: getRobotRelativeSpeeds,
         //      (speeds, feedforwards) -> driveRobotRelatiive(speeds),



        //);
    }

   // public Pose2d getPose(){return poseEstimator.getEstimatedPosition();
    
    //public void resetPose(Rotation2d gyroAngle, double leftPositionMeters, double rightPositionMeters, Pose2d poseMeters){poseEstimator.resetPose(Pose2d.kZero);}
    //public Pose2d getRobotRelativeSpeeds{return poseEstimator.ChassisSpeeds}

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
    public void arcadeDrive(double movespeed, double turnspeed){drive.arcadeDrive(movespeed, turnspeed);}
  /* public void motorvalue(double percentOutputRight, double percentOutputLeft){
        talonleft.set(TalonSRXControlMode.PercentOutput,percentOutputLeft);
        talonright.set(TalonSRXControlMode.PercentOutput, percentOutputRight);
    } */


}
