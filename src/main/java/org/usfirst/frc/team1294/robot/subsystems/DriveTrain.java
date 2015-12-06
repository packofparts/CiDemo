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
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new TankDriveWithJoystick());
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

	public void tankDrive(Joystick left, Joystick right) {
		drive.tankDrive(left, right);
		
		SmartDashboard.putNumber("leftEncVelocity", leftTalon.getEncVelocity());
		SmartDashboard.putNumber("rightEncVelocity", rightTalon.getEncVelocity());
		SmartDashboard.putNumber("leftCommandedVelocity", leftTalon.get());
		SmartDashboard.putNumber("rightCommandedVelocity", rightTalon.get());
		SmartDashboard.putNumber("leftInput", left.getY());
		SmartDashboard.putNumber("rightInput", right.getY());
	}
	
	public void arcadeDrive(Joystick left){
		drive.arcadeDrive(left);
		
		SmartDashboard.putNumber("leftEncVelocity", leftTalon.getEncVelocity());
		SmartDashboard.putNumber("leftCommandedVelocity", leftTalon.get());
		
		SmartDashboard.putNumber("rightEncVelocity", rightTalon.getEncVelocity());
		SmartDashboard.putNumber("rightCommandedVelocity", rightTalon.get());
		
		SmartDashboard.putNumber("forwardInput", left.getY());
		SmartDashboard.putNumber("yawInput", left.getX());
		
		SmartDashboard.putNumber("distanceLeft", leftTalon.getPosition());
		SmartDashboard.putNumber("distanceRight", rightTalon.getPosition());
	}

	public void arcadeDrive(double y, double d) {
		drive.arcadeDrive(y, d);
		
		SmartDashboard.putNumber("leftEncVelocity", leftTalon.getEncVelocity());
		SmartDashboard.putNumber("leftCommandedVelocity", leftTalon.get());
		
		SmartDashboard.putNumber("rightEncVelocity", rightTalon.getEncVelocity());
		SmartDashboard.putNumber("rightCommandedVelocity", rightTalon.get());
		
		SmartDashboard.putNumber("forwardInput", y);
		SmartDashboard.putNumber("yawInput", d);
		
		SmartDashboard.putNumber("distanceLeft", leftTalon.getPosition());
		SmartDashboard.putNumber("distanceRight", rightTalon.getPosition());
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
}