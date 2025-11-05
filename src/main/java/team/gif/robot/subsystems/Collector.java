// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class Collector extends SubsystemBase {
    private TalonSRX collectorMotor;

    /** Creates a new ExampleSubsystem. */
    public Collector() {
        collectorMotor = new TalonSRX(RobotMap.COLLECTOR_TALON_ID);
        collectorMotor.configFactoryDefault();
        collectorMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setPercentOutput ( double percent) {
        collectorMotor.set(ControlMode.PercentOutput, percent);
    }

}
