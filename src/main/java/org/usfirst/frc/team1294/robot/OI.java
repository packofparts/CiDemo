package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team1294.robot.commands.ReversedControls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick stickLeft = new Joystick(0);
    
	Joystick stickRight = new Joystick(1);
	
	Button leftButton1 = new JoystickButton(stickLeft, 1);
	Button rightButton1 = new JoystickButton(stickRight, 1);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    public OI (){
    	//leftButton1.toggleWhenPressed(new ReversedControls());
    	
    		leftButton1.whenPressed(new DriveDistanceCommand(10000));
    }
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public Joystick getStickLeft() {
		return stickLeft;
	}
	
	public Joystick getStickRight() {
		return stickRight;
	}
}

