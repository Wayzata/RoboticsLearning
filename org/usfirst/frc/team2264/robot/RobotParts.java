package org.usfirst.frc.team2264.robot;

/**
 * RobotParts is a class of constants that represent the parts on the robot.
 */
public final class RobotParts {
	public static final class MOTORS {
		public static final int FRONT_LEFT = 14;
		public static final int REAR_LEFT = 13;
		public static final int FRONT_RIGHT = 11;
		public static final int REAR_RIGHT = 12;
		
		public static final int CLAW_HORIZONTAL = 15;
		public static final int CLAW_VERTICAL = 16;
	}
	public static final class AXES {
		public static final int X = 0;
		public static final int Y = 1;
		public static final int TWIST = 3;
	}
	public static final int SAFETY_DISABLE_BUTTON = 1;
	public static final int CLAW_SAFETY_SWITCH = 2;
	public static final int JOYSTICK = 0;
}
