package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

	private double startDistance;
	private double desiredDistance;

	public DriveDistance(double distance) {
		requires(Robot.driveTrain);
		desiredDistance = distance;
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.arcadeDrive(-0.5, 0);
	}

	@Override
	protected void initialize() {
		startDistance = Robot.driveTrain.getDistanceLeft();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.getDistanceLeft() - startDistance >= desiredDistance;
	}

}
