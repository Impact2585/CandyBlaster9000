package org.usfirst.frc.team2585.systems;

import org.impact2585.lib2585.RampedSpeedController;
import org.usfirst.frc.team2585.robot.Environment;
import org.usfirst.frc.team2585.robot.RobotMap;

/**
 * This system shoots candy whenever a button is pressed
 */
public class CandyShooterSystem extends RobotSystem implements Runnable {
	RampedSpeedController candyMotor;
	
	//This number needs to be adjusted I MADE 0.6 UP, DO NOT USE!!!
	static double candyMotorSpeed = 0.6;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.usfirst.frc.team2585.systems.RobotSystem#init(org.usfirst.frc.team2585.
	 * robot.Environment)
	 */
	@Override
	public void init(Environment environ) {
		super.init(environ);

		candyMotor = new RampedSpeedController(RobotMap.SHOOTER_MOTOR);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		if (input.shouldShoot()) {
			setMotorSpeed(candyMotorSpeed);
		} else {
			setMotorSpeed(0);
		}
	}

	/**
	 * @param candyMotorSpeed is the speed to set the motor to
	 */
	public void setMotorSpeed(double candyMotorSpeed) {
		candyMotor.updateWithSpeed(candyMotorSpeed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.impact2585.lib2585.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		candyMotor.destroy();
	}

	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.systems.RobotSystem#stop()
	 */
	@Override
	public void stop() {
		setMotorSpeed(0);
	}

}