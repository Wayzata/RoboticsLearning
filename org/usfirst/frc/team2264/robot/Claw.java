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
		// TODO
	}

	/**
	 * Sets the horizontal motor to move in the requested direction.
	 * @param direction Whether the claw should be opened, closed, or motion should be stopped.
	 * @param safety Whether safety measures are enabled or not.
	 */
	public void setHorizontalDirection(HorizontalDirection direction, boolean safety) {
		// TODO
	}

	/**
	 * Sets the horizontal motor to move in the requested direction.
	 * @param pov The POV angle to choose a direction from.
	 * @param safety Whether safety measures are enabled or not.
	 */
	public void setHorizontalDirection(int pov, boolean safety) {
		// TODO
	}

	/**
	 * Sets the vertical motor to move in the requested direction.
	 * @param direction The direction to move in.
	 */
	public void setVerticalDirection(VerticalDirection direction) {
		// TODO
	}
	/**
	 * Sets the vertical motor to move in the requested direction.
	 * @param pov The POV angle to choose a direction from.
	 */
	public void setVerticalDirection(int pov) {
		// TODO
	}

	/**
	 * Direction constants for the horizontal motor.
	 */
	public static enum HorizontalDirection {
		OPEN(1.0),
		STOP(0.0),
		CLOSED(-1.0);

		private double speed;
		private HorizontalDirection(double speed) { this.speed = speed; }

		/**
		 * Returns the speed the horizontal motor should spin at to move in the
		 * requested direction.
		 * @return The desired motor speed.
		 */
		public double getSpeed() { return this.speed; }
	}

	/**
	 * Direction constants for the vertical motor.
	 */
	public static enum VerticalDirection {
		UP(1.0),
		STOP(0.0),
		DOWN(-1.0);

		private double speed;
		private VerticalDirection(double speed) { this.speed = speed; }

		/**
		 * Returns the speed the horizontal motor should spin at to move in the
		 * requested direction.
		 * @return The desired motor speed.
		 */
		public double getSpeed() { return this.speed; }
	}
}
