package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class tankDrive extends Command {

    public tankDrive() {
        super();
        addRequirements(Robot.driveMotorSystem); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double rightPosition = -Robot.oi.driver.getRightY();
        double leftPosition = Robot.oi.driver.getLeftY();
        Robot.driveMotorSystem.tankDrive(leftPosition,rightPosition);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) { Robot.driveMotorSystem.tankDrive(0,0);

    }
}
