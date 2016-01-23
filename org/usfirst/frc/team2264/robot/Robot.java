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
	
		DigitalInput DI = new DigitalInput(RobotParts.CLAW_SAFETY_SWITCH);
		CANTalon horizontalMotor = new CANTalon(RobotParts.MOTORS.CLAW_HORIZONTAL);		
		CANTalon verticalMotor = new CANTalon(RobotParts.MOTORS.CLAW_VERTICAL);
		this.claw = new Claw(horizontalMotor, verticalMotor, DI);
		
		// Initialize the drive train.
		CANTalon frontLeft = new CANTalon(RobotParts.MOTORS.FRONT_LEFT);
		CANTalon frontRight = new CANTalon(RobotParts.MOTORS.FRONT_RIGHT);
		CANTalon rearLeft = new CANTalon(RobotParts.MOTORS.REAR_LEFT);
		CANTalon rearRight = new CANTalon(RobotParts.MOTORS.REAR_RIGHT);
		
		this.drive = new RobotDrive (frontLeft, frontRight, rearLeft, rearRight);
		
		
		 
		

		// Initialize the joystick.
		this.joystick = new Joystick(0);
		
	}

	/**
	 * This function is called periodically during the teleop period.
	 */
	public void teleopPeriodic() {
		
		this.joystick.getRawAxis(RobotParts.AXES.X);
		this.joystick.getRawAxis(RobotParts.AXES.Y);
		this.joystick.getRawAxis(RobotParts.AXES.TWIST);
		this.joystick.getRawButton(RobotParts.SAFETY_DISABLE_BUTTON);
		this.joystick.getPOV();
		
	
	
		// Set the drive motors as indicated by the joystick.

		this.drive.mecanumDrive_Cartesian(this.joystick.getRawAxis(RobotParts.AXES.X),this.joystick.getRawAxis(RobotParts.AXES.Y),this.joystick.getRawAxis(RobotParts.AXES.TWIST),0);
		//this.drive.mecanumDrive_Cartesian(0, 0, .18, 0);
		

		// Set the movement for the claw mechanism.
		this.claw.setVerticalDirection(this.joystick.getPOV());
		this.claw.setHorizontalDirection(this.joystick.getPOV(), joystick.getRawButton(RobotParts.SAFETY_DISABLE_BUTTON));
		
		//this. has a claw. The claw in this. uses the getPOV from the joystick object to set the
		//vertical direction of the motor for the claw.
		//Not only does this have to get getPOV, it also has to manage the safety buttom. 
		
	}
}
