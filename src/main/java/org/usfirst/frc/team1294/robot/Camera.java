package org.usfirst.frc.team1294.robot;

import edu.wpi.first.wpilibj.CameraServer;

/**
 * A simple {@link Subsystem} to setup and stream a USB camera feed to the DS.
 *
 * @author Austin Jenchi (timtim17)
 */
public class Camera {
    private CameraServer cameraServer;
    private String name;
    private int quality;
    
    private static final String DEFAULT_CAMERA_NAME = "cam0";
    private static final int DEFAULT_CAMERA_QUALITY = 50;

    /**
     * Works like {@link #CameraSubsystem(String, int)} but {@code name} is set to {@code "cam0"} and {@code quality} is set to 50.
     *
     * @see #CameraSubsystem(String, int)
     */
    public Camera() {
        this(DEFAULT_CAMERA_NAME);
    }

    /**
     * Works like {@link #CameraSubsystem(String, int)} but {@code quality} is set to 50.
     *
     * @param name The name of the camera in the roboRIO's webdash.
     */
    public Camera(String name) {
        this(name, DEFAULT_CAMERA_QUALITY);
    }

    /**
     * Works like {@link #CameraSubsystem(String, int)} but {@code name} is set to {@code "cam0"}.
     *
     * @param quality The quality on a scale from 0 to 100.
     */
    public Camera(int quality) {
        this(DEFAULT_CAMERA_NAME, quality);
    }

    /**
     * Sets up a camera with the given name and quality level.
     *
     * @param name The name of the camera in the roboRIO's webdash.
     * @param quality The quality on a scale from 0 to 100.
     */
    public Camera(String name, int quality) {
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

    // getName() is a function defined in Subsystem, so to avoid risk of overriding it I've simply renamed this function
    public String getCameraName() {
        return name;
    }

    /**
     * <strong>This method is untested and not guaranteed to work.</strong>
     * <br><br>
     * Changes the name of the camera used for auto capture.
     */
    public void setName(String newName) {
        this.name = newName;
        if (cameraServer.isAutoCaptureStarted()) {
            // the camera has already been started
            // with the old name, restart it with the new name
            startCameraStream();
        }
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
}
