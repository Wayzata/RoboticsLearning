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
		// TODO

		// Initialize the drive train.
		// TODO

		// Initialize the joystick.
		// TODO
	}

	/**
	 * This function is called periodically during the teleop period.
	 */
	public void teleopPeriodic() {
		// Get the axes, "safety button", and POV from the joystick.
		// TODO

		// Set the drive motors as indicated by the joystick.
		// TODO

		// Set the movement for the claw mechanism.
		// TODO
	}
}
