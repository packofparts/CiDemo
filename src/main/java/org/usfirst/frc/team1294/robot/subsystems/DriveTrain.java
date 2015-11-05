package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.ArcadeDriveWithJoystick;
import org.usfirst.frc.team1294.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem {
	
	private CANTalon leftMotor;
	private CANTalon rightMotor;
	
	private RobotDrive drive;

	public DriveTrain() {
		super();
		leftMotor = new CANTalon(RobotMap.leftMotor);
		rightMotor = new CANTalon(RobotMap.rightMotor);
		drive = new RobotDrive(leftMotor, rightMotor);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

	public void tankDrive(Joystick left, Joystick right) {
		drive.tankDrive(left, right);
	}
	public void arcadeDrive(Joystick left){
		drive.arcadeDrive(left);
	}

	public void arcadeDrive(double y, double d) {
		// TODO Auto-generated method stub
		drive.arcadeDrive(y, d);
		
	}

	
}