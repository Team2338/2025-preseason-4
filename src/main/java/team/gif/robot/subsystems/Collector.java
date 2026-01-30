// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */

    private final SparkMax sparkMax;
    private final SparkClosedLoopController sparkClosedLoopController;
    private final RelativeEncoder relativeEncoder;

    public Collector() {
        sparkMax = new SparkMax(45, SparkLowLevel.MotorType.kBrushless);
        sparkClosedLoopController = sparkMax.getClosedLoopController();
        relativeEncoder = sparkMax.getEncoder();

        SparkMaxConfig config = new SparkMaxConfig();
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);
        config.inverted(true);

        config.closedLoop.pid(0.001,0.0000004,0.004);
        sparkMax.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
    }

    public void setRPM(double setpoint){
        sparkClosedLoopController.setReference(setpoint, SparkBase.ControlType.kVelocity);
    }

    public void setVoltage(double voltage){sparkMax.setVoltage(voltage);}

    public double encoderVelocity(){return relativeEncoder.getVelocity();}
}
