package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveWithJoystick extends Command{

	public ArcadeDriveWithJoystick() {
		// TODO Auto-generated constructor stub
		 requires(Robot.driveTrain);
	}
	protected void execute() {
    	Robot.driveTrain.arcade(Robot.oi.getStickLeft());
    }
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
