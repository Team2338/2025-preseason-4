// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

import static team.gif.robot.Constants.MOTORSPEED;



import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveMotorSystem extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public TalonSRX tmotor;
    public DriveMotorSystem() {
        tmotor = new TalonSRX(RobotMap.TALON_MOTOR_ID);
        tmotor.configFactoryDefault();
        tmotor.setNeutralMode(NeutralMode.Brake);

    }
   public void motorvalue(double percentOutput){tmotor.set(TalonSRXControlMode.PercentOutput,percentOutput);}


}
