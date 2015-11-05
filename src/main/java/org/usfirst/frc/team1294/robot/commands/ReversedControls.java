package org.usfirst.frc.team1294.robot.commands;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReversedControls extends Command{

	public ReversedControls() {
		requires(Robot.driveTrain);
		// TODO Auto-generated constructor stub
	}
	protected void execute() {
    	Robot.driveTrain.arcadeDrive(Robot.oi.getStickLeft().getY(), Robot.oi.getStickLeft().getX()*-1);
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
		end();
		
	}

}
