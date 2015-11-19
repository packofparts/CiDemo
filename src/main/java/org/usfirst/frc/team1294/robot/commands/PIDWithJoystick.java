package org.usfirst.frc.team1294.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1294.robot.Robot;

public class PIDWithJoystick extends Command{

//	private float distance;

	public PIDWithJoystick() {
		// TODO Auto-generated constructor stub
		super("PIDTalonEncoderCommand");
		requires(Robot.driveTrain);
//		distance = 0;
	}
	protected void execute() {
		Robot.driveTrain.leftMotor.setPID(SmartDashboard.getNumber("p", 0), SmartDashboard.getNumber("i", 0), SmartDashboard.getNumber("d", 0));
//    	distance += Robot.oi.getStickLeft().getY();
//		Robot.driveTrain.leftMotor.set(0.5);
		Robot.driveTrain.leftMotor.set(SmartDashboard.getNumber("speed", 0.5));
		Robot.driveTrain.rightMotor.set(0.5);
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
