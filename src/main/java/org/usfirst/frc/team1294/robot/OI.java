package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.DriveDistance;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    Joystick stickLeft = new Joystick(0);
    
	Joystick stickRight = new Joystick(1);
	
	Button leftButton1 = new JoystickButton(stickLeft, 1);
	Button rightButton1 = new JoystickButton(stickRight, 1);
 
    public OI (){
    	leftButton1.whileHeld(new DriveDistance(10000, 0.5));
    }
	
	public Joystick getStickLeft() {
		return stickLeft;
	}
	
	public Joystick getStickRight() {
		return stickRight;
	}
}

