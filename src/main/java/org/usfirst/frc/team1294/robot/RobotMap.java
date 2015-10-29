package org.usfirst.frc.team1294.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static int leftMotor = 2;
    public static int rightMotor = 1;

    public static final int leftJoystick = 0, rightJoystick = 1;
    public static final int startCCButton = 6, stopCCButton = 7;
}
