package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin Jenchi (timtim17)
 */
public class CruiseControlCommand extends Command {

    public enum DriveType {TANK_DRIVE, ARCADE_DRIVE}

    private DriveType driveType;
    private double input1, input2;

    public CruiseControlCommand(double input1, double input2, DriveType driveType) {
        requires(Robot.driveTrain);

        this.driveType = driveType;
        this.input1 = input1;
        this.input2 = input2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (driveType == DriveType.ARCADE_DRIVE) {
            Robot.driveTrain.arcadeDrive(input1, input2);
        } else {
            Robot.driveTrain.tankDrive(input1, input2);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
