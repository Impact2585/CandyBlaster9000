package org.usfirst.frc.team2585.input;

import org.impact2585.lib2585.XboxConstants;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Input from a single XBox controller
 */
public class XBoxInput extends InputMethod {
	private static double minTriggerActuation = 0.1;
	private Joystick controller;
	
	/**
	 * Initializes the controller
	 */
	public XBoxInput() {
		// 0 is the port # of the driver station the joystick is plugged into
		controller = new Joystick(0);
	}
	
	/* (non-Javadoc)
	 * @see input.InputMethod#forwardAmount()
	 */
	@Override
	public double forwardAmount() {
		return controller.getRawAxis(XboxConstants.LEFT_Y_AXIS);
	}
	
	/* (non-Javadoc)
	 * @see input.InputMethod#rotationAmount()
	 */
	@Override
	public double rotationAmount() {
		return controller.getRawAxis(XboxConstants.RIGHT_X_AXIS);
	}
	
	/* (non-Javadoc)
	 * @see input.InputMethod#shouldShoot()
	 */
	@Override
	public boolean shouldShoot() {
		return controller.getRawAxis(XboxConstants.RIGHT_TRIGGER) > minTriggerActuation;
	}

	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.input.InputMethod#shouldHighFiveUp()
	 */
	@Override
	public boolean shouldHighFiveUp() {
		return controller.getRawButton(XboxConstants.B_BUTTON);
	}
	
	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.input.InputMethod#shouldHighFiveDown()
	 */
	@Override
	public boolean shouldHighFiveDown() {
		return controller.getRawButton(XboxConstants.A_BUTTON);
	}
}
