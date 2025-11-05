package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;
public class Shooter extends SubsystemBase {

    private TalonSRX motortop;
    private TalonSRX motorbottom;

    public Shooter() {
        motortop = new TalonSRX(RobotMap.WINCH_MOTOR_ID);
        motortop.configFactoryDefault();
        motortop.setNeutralMode(NeutralMode.Brake);
        motorbottom = new TalonSRX(RobotMap.WINCH_MOTOR_ID_BOTTOM);
        motorbottom.configFactoryDefault();
        motorbottom.setNeutralMode(NeutralMode.Brake);
    }

    public void setSpeed(double percentOutputTop, double percentOutputBot) {
        motortop.set(TalonSRXControlMode.PercentOutput, percentOutputTop);
        motorbottom.set(TalonSRXControlMode.PercentOutput, percentOutputBot);
    }
}


