package org.usfirst.frc.team2264.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * This is the main class.
 */
public class Robot extends IterativeRobot {
	private Claw claw;
	private RobotDrive drive;
	private Joystick joystick;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Initialize the claw.
    	this.claw = new Claw(new CANTalon(RobotParts.MOTORS.CLAW_HORIZONTAL),
    			new CANTalon(RobotParts.MOTORS.CLAW_VERTICAL),
    			new DigitalInput(RobotParts.CLAW_SAFETY_SWITCH));
    	// Initialize the drive train.
    	this.drive = new RobotDrive(new CANTalon(RobotParts.MOTORS.FRONT_LEFT),
    			new CANTalon(RobotParts.MOTORS.REAR_LEFT),
    			new CANTalon(RobotParts.MOTORS.FRONT_RIGHT),
    			new CANTalon(RobotParts.MOTORS.REAR_RIGHT));
    	// Initialize the joystick.
    	this.joystick = new Joystick(RobotParts.JOYSTICK);
    }

    /**
     * This function is called periodically during the teleop period.
     */
    public void teleopPeriodic() {
        // Get the axes, "safety button", and POV from the joystick.
    	double x = this.joystick.getRawAxis(RobotParts.AXES.X),
    			y = this.joystick.getRawAxis(RobotParts.AXES.Y),
    			twist = this.joystick.getRawAxis(RobotParts.AXES.TWIST);
        boolean safety = this.joystick.getRawButton(RobotParts.SAFETY_DISABLE_BUTTON);
        int pov = this.joystick.getPOV();
    	// Set the drive motors as indicated by the joystick.
        this.drive.mecanumDrive_Cartesian(x, y, twist, 0.0);
        // Set the movement for the claw mechanism.
        this.claw.setHorizontalDirection(pov, safety);
        this.claw.setVerticalDirection(pov);
    }
}
