package org.usfirst.frc.team1294.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A simple {@link Subsystem} to setup and stream a USB camera feed to the DS.
 *
 * @author Austin Jenchi (timtim17)
 */
public class CameraSubsystem extends Subsystem {
    private CameraServer cameraServer;
    private String name;
    private int quality;

    /**
     * Works like {@link #CameraSubsystem(String, int)} but {@code name} is set to {@code "cam0"} and {@code quality} is set to 50.
     *
     * @see #CameraSubsystem(String, int)
     */
    public CameraSubsystem() {
        this("cam0", 50);
    }

    /**
     * Works like {@link #CameraSubsystem(String, int)} but {@code quality} is set to 50.
     *
     * @param name The name of the camera in the roboRIO's webdash.
     */
    public CameraSubsystem(String name) {
        this(name, 50);
    }

    /**
     * Works like {@link #CameraSubsystem(String, int)} but {@code name} is set to {@code "cam0"}.
     *
     * @param quality The quality on a scale from 0 to 100.
     */
    public CameraSubsystem(int quality) {
        this("cam0", quality);
    }

    /**
     * Sets up a camera with the given name and quality level.
     *
     * @param name The name of the camera in the roboRIO's webdash.
     * @param quality The quality on a scale from 0 to 100.
     */
    public CameraSubsystem(String name, int quality) {
        super("Camera");
        this.name = name;
        if (quality < 0 || quality > 100) throw new IllegalArgumentException("Invalid camera quality.");
        this.quality = quality;
        cameraServer = CameraServer.getInstance();
        cameraServer.setQuality(quality);
    }

    /**
     * Start capturing and broadcasting camera images to the DS.
     *
     * @see CameraServer#startAutomaticCapture(String)
     */
    public void startCameraStream() {
        cameraServer.startAutomaticCapture(name);
    }

    // getName() is a function defined in SubSystem, so to avoid risk of overriding it I've simply renamed this function
    public String getCameraName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuaity(int quality) {
        this.quality = quality;
        cameraServer.setQuality(quality);
    }

    public boolean isCaptureStarted() {
        return cameraServer.isAutoCaptureStarted();
    }

    @Override
    protected void initDefaultCommand() {
        // setDefaultCommand(Command);
    }
}
