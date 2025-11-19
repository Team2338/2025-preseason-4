package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class FootballShooter extends Command {

    public FootballShooter() {
        super();
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        // prints and 0,0 are placeholders/test commands
        double distanceFromTag = Robot.shooterLimelight.getDistance();

        if (distanceFromTag > Constants.ShooterLimelight.distanceClose){
            System.out.println("Close");
            Robot.shooter.setSpeed(.1,.1);
        }
        else if (distanceFromTag > Constants.ShooterLimelight.distanceFar){
            System.out.println("Far");
            Robot.shooter.setSpeed(.3,.3);
        }else {
            System.out.println("Middle");
            Robot.shooter.setSpeed(.2,.2);
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {Robot.shooter.setSpeed(0,0);}
}
