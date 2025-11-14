// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

import static team.gif.robot.Constants.*;
import static team.gif.robot.RobotMap.SPARK_MAX_ID;

public class DriveMotorSystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public SparkMax sparkleft;
    public SparkMax sparkright;
    public SparkMaxConfig babsSparkConfigleft;
    public SparkMaxConfig babsSparkConfigright;
    public RelativeEncoder sparkEncoderleft;
    public RelativeEncoder sparkEncoderright;
    public SparkClosedLoopController motorloopleft;
    public SparkClosedLoopController motorloopright;
    public DifferentialDrive drive;
    public DriveMotorSystem() {
        sparkleft = new SparkMax(SPARK_MAX_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderleft = sparkleft.getEncoder();
        sparkleft.configure(babsSparkConfigleft, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        babsSparkConfigleft.idleMode(SparkBaseConfig.IdleMode.kBrake);
        babsSparkConfigleft.inverted(true);
        motorloopleft = sparkleft.getClosedLoopController();
        babsSparkConfigleft.closedLoop.p(kP);
        babsSparkConfigleft.closedLoop.i(kI);
        babsSparkConfigleft.closedLoop.d(kD);


        sparkright = new SparkMax(SPARK_MAX_ID, SparkLowLevel.MotorType.kBrushless);
        sparkEncoderright = sparkright.getEncoder();
        sparkright.configure(babsSparkConfigright, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        babsSparkConfigright.idleMode(SparkBaseConfig.IdleMode.kBrake);
        babsSparkConfigright.inverted(true);
        motorloopright = sparkright.getClosedLoopController();
        babsSparkConfigright.closedLoop.p(kP);
        babsSparkConfigright.closedLoop.i(kI);
        babsSparkConfigright.closedLoop.d(kD);


        drive = new DifferentialDrive(sparkleft, sparkright);


    }
    public double velocityGetleft(){
        return  sparkEncoderleft.getVelocity();
    }
    public double velocityGetright() {

        return sparkEncoderright.getVelocity();
    }
    public void setRPM(double RPM){
        motorloopleft.setReference(RPM, SparkBase.ControlType.kVelocity);
        motorloopright.setReference(RPM, SparkBase.ControlType.kVelocity);
    }
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
