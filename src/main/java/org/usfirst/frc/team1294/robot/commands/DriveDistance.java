package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

	private double startDistance;
	private double desiredDistance;
	private double desiredSpeed;

	public DriveDistance(double distance, double speed) {
		requires(Robot.driveTrain);
		this.desiredDistance = distance;
		this.desiredSpeed = speed;
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void execute() {
		Robot.driveTrain.arcadeDrive(-this.desiredSpeed, 0);
	}

	@Override
	protected void initialize() {
		startDistance = Robot.driveTrain.getDistanceLeft();
	}

	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.getDistanceLeft() - startDistance >= desiredDistance;
	}
}
