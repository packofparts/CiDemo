package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.ArcadeDriveWithJoystick;
import org.usfirst.frc.team1294.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem {
	
	private CANTalon leftTalon;
	private CANTalon rightTalon;
	
	private RobotDrive drive;

	public DriveTrain() {
		super();
		leftTalon = new CANTalon(RobotMap.leftTalon);
		rightTalon = new CANTalon(RobotMap.rightTalon);
		drive = new RobotDrive(leftTalon, rightTalon);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		leftTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftTalon.changeControlMode(CANTalon.ControlMode.Position);
		rightTalon.set(0.5);
		leftTalon.setPID(RobotMap.p, RobotMap.i, RobotMap.d);
		rightTalon.setPID(RobotMap.p, RobotMap.i, RobotMap.d);
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