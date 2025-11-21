package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class AutoDriveForward extends Command {
    public int time;

    public AutoDriveForward() {
        super();
        addRequirements(Robot.driveMotorSystem); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        time = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        if (time <= 50){
            time += 1;
            //Robot.driveMotorSystem.tankDrive(.1,.1);
            Robot.driveMotorSystem.arcadeDrive(.1,0);
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return time>50;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //Robot.driveMotorSystem.tankDrive(0,0);
        Robot.driveMotorSystem.arcadeDrive(0,0);
        }
}
