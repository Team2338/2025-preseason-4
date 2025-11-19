package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
public class Shooter extends SubsystemBase {

    private final TalonSRX motorTop;
    private final TalonSRX motorBottom;

    public Shooter() {
        motorTop = new TalonSRX(RobotMap.WINCH_MOTOR_ID);
        motorTop.configFactoryDefault();
        motorTop.setNeutralMode(NeutralMode.Brake);
        motorBottom = new TalonSRX(RobotMap.WINCH_MOTOR_ID_BOTTOM);
        motorBottom.configFactoryDefault();
        motorBottom.setNeutralMode(NeutralMode.Brake);
    }

    public void setSpeed(double percentOutputTop, double percentOutputBot) {
        motorTop.set(ControlMode.PercentOutput, percentOutputTop);
        motorBottom.set(ControlMode.PercentOutput, percentOutputBot);
    }
}


