package org.usfirst.frc.team2264.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The Claw class manages the claw, both the vertical and horizontal axis.
 */
public class Claw {
	private CANTalon horizontal, vertical;
	private DigitalInput limitSwitch;
	private HorizontalDirection lastHorizontalDirection;

	/**
	 * Initializes the Claw.
	 * @param horizontal The motor used to open and close the claw.
	 * @param vertical The motor used to raise and lower the claw.
	 * @param limitSwitch The switch which is triggered if the claw is about to open or close too far.
	 */
	public Claw(CANTalon horizontal, CANTalon vertical, DigitalInput limitSwitch) {
	
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.limitSwitch = limitSwitch;
		this.lastHorizontalDirection = HorizontalDirection.STOP;
		//constructors giving values to each instance variables 
		//CANTalon horizontal is called horizontal, CANTalon vertical is called vertical
		//DigitalInput is called limitSwitch, HorizontalDirection is called lastHorizontalDirection
		
	}

	/**
	 * Sets the horizontal motor to move in the requested direction.
	 * @param direction Whether the claw should be opened, closed, or motion should be stopped.
	 * @param safety Whether safety measures are enabled or not.
	 */
	public void setHorizontalDirection(HorizontalDirection direction, boolean safety) {
		// TODO
		/* If the safety is on and the limit switch is activated and we're still
		 * trying to go further in the same direction disable the robot.
		 * 
		 * Otherwise, set the horizontal direction as normal.
		 */
		if (((limitSwitch.get() && safety) && (direction == lastHorizontalDirection))) {
			this.horizontal.disableControl();
		}
		else {
			this.horizontal.set(direction.getSpeed());
		}
		this.lastHorizontalDirection = direction;
		//If safety and the limit switch is turned on and the arm is still trying to move in the
		//direction the robot is disabled
		//otherwise the direction is set back to the normal speed
		// Calls variable horizontal. The set sets the speed of the horizontal motor, sets the speed
		//to the passed in direction
	}

	/**
	 * Sets the horizontal motor to move in the requested direction.
	 * @param pov The POV angle to choose a direction from.
	 * @param safety Whether safety measures are enabled or not.
	 */
	public void setHorizontalDirection(int pov, boolean safety) {
		
		if ((180 < pov) && (pov <= 359)) {
		this.setHorizontalDirection(HorizontalDirection.OPEN, safety);
		}
		else if ((0 < pov) && (pov <= 179)) {
		this.setHorizontalDirection(HorizontalDirection.CLOSED, safety);
		}
		else {
		this.setHorizontalDirection(HorizontalDirection.STOP, safety);
		}
	}
		//if the pov is pressed on the left side the arm is to open
		//if the pov is pressed on the right side the arm is to close
		//if the pov is not pressed at the certain angles it is to stop

	/**
	 * Sets the vertical motor to move in the requested direction.
	 * @param direction The direction to move in.
	 */
	public void setVerticalDirection(VerticalDirection direction) {
		
		this.vertical.set(direction.getSpeed());
		// Calls variable vertical. Sets the speed of the vertical motor to the passed in direction
		//sets the vertical direction as normal.
	}
	/**
	 * Sets the vertical motor to move in the requested direction.
	 * @param pov The POV angle to choose a direction from.
	 */
	public void setVerticalDirection(int pov) {

		if ((270 < pov) || (pov <= 89)) {
			this.setVerticalDirection(VerticalDirection.UP);
		}
		else if ((90 < pov) && (pov <= 269)) {
			this.setVerticalDirection(VerticalDirection.DOWN);
		}
		else {
			this.setVerticalDirection(VerticalDirection.STOP);
		}
	}
	//if the pov is pressed on the top the arm is to move up
	//if the pov is pressed on the bottom the arm is to move down
		//otherwise if the pov is not pressed at th certain angles the arm is to stop

	/**
	 * Direction constants for the horizontal motor.
	 */
	public static enum HorizontalDirection {
		OPEN(1.0),
		STOP(0.0),
		CLOSED(-1.0);
		//constants used to label OPEN, CLOSED, and STOP

		private double speed;
		private HorizontalDirection(double speed) { this.speed = speed; }
		//inputing a HorizontalDirection with a speed

		/**
		 * Returns the speed the horizontal motor should spin at to move in the
		 * requested direction.
		 * @return The desired motor speed.
		 */
		//
		public double getSpeed() { return this.speed; }
	}
		//returns the speed back to its original speed

	/**
	 * Direction constants for the vertical motor.
	 */
	public static enum VerticalDirection {
		UP(-1.0),
		STOP(0.0),
		DOWN(1.0);
		//constants used to label UP, DOWN, and STOP

		private double speed;
		private VerticalDirection(double speed) { this.speed = speed; }
		//inputing a VerticalDirection with a speed

		/**
		 * Returns the speed the horizontal motor should spin at to move in the
		 * requested direction.
		 * @return The desired motor speed.
		 */
		public double getSpeed() { return this.speed; }
		//retuens the speed back to its originakl speed
	}
}
