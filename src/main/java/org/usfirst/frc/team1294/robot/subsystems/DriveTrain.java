package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.ArcadeDriveWithJoystick;


public class DriveTrain extends Subsystem {
	
	public CANTalon leftMotor;
	public CANTalon rightMotor;

	public RobotDrive drive;

	public DriveTrain() {
		super();
		leftMotor = new CANTalon(RobotMap.leftMotor);
		rightMotor = new CANTalon(RobotMap.rightMotor);
		leftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		leftMotor.setPID(SmartDashboard.getNumber("p", 0), SmartDashboard.getNumber("i", 0), SmartDashboard.getNumber("d", 0));
		leftMotor.changeControlMode(CANTalon.ControlMode.Speed);
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

	
}