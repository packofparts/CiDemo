package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.DriveDistance;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1294.robot.commands.ResetEncoderCommand;

public class OI {
    Joystick stickLeft = new Joystick(0);
    
	Joystick stickRight = new Joystick(1);
	
	Button leftButton1 = new JoystickButton(stickLeft, 1);
	Button rightButton1 = new JoystickButton(stickRight, 1);
	Button resetEncoderButton = new JoystickButton(stickLeft, 10);
 
    public OI (){
    	leftButton1.whenPressed(new DriveDistance(10000, 0.5));
		resetEncoderButton.whenPressed(new ResetEncoderCommand());
    }
	
	public Joystick getStickLeft() {
		return stickLeft;
	}
	
	public Joystick getStickRight() {
		return stickRight;
	}
}

