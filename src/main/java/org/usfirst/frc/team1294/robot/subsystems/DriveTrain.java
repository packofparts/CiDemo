package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
	
	private CANTalon leftTalon;
	private CANTalon rightTalon;
	
	private RobotDrive drive;

	public DriveTrain() {
		super();
		leftTalon = new CANTalon(RobotMap.leftTalon);
		leftTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftTalon.changeControlMode(CANTalon.ControlMode.Speed);
		
		rightTalon = new CANTalon(RobotMap.rightTalon);
		rightTalon.changeControlMode(CANTalon.ControlMode.Speed);
		rightTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		drive = new RobotDrive(leftTalon, rightTalon);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		drive.setMaxOutput(2048);

		resetEncoders();
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new TankDriveWithJoystick());
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

	public void tankDrive(Joystick left, Joystick right) {
		drive.tankDrive(left, right);
		printDataToSmartDashboard();
	}
	
	public void arcadeDrive(Joystick left){
		drive.arcadeDrive(left);
		printDataToSmartDashboard();
	}

	public void arcadeDrive(double y, double d) {
		drive.arcadeDrive(y, d);
		printDataToSmartDashboard();
	}
	
	public double getDistanceLeft() {
		return leftTalon.getPosition();
	}
	
	public double getDistanceRight() {
		return rightTalon.getPosition();
	}
	
	public void stop() {
		drive.drive(0,0);
	}
	
	private void printDataToSmartDashboard() {
		SmartDashboard.putNumber("DriveTrain.LeftTalon.EncVelocity", leftTalon.getEncVelocity());
		SmartDashboard.putNumber("DriveTrain.LeftTalon.Position", leftTalon.getPosition());
		SmartDashboard.putNumber("DriveTrain.LeftTalon.Get", leftTalon.get());
		
		SmartDashboard.putNumber("DriveTrain.RightTalon.EncVelocity", rightTalon.getEncVelocity());
		SmartDashboard.putNumber("DriveTrain.RightTalon.Position", rightTalon.getPosition());
		SmartDashboard.putNumber("DriveTrain.RightTalon.Get", rightTalon.get());
	}

	public void resetEncoders() {
		leftTalon.setPosition(0);
		rightTalon.setPosition(0);
	}
}