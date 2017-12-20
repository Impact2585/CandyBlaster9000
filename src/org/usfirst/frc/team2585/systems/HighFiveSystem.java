package org.usfirst.frc.team2585.systems;

import org.usfirst.frc.team2585.robot.Environment;
import org.usfirst.frc.team2585.robot.RobotMap;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * The system that gives high fives when the user presses a button
 */
public class HighFiveSystem extends RobotSystem implements Runnable {
	SpeedController lowerArmMotor;
	SpeedController upperArmMotor;
	
	static double highFiveSpeed = 0.8;
	
	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.systems.RobotSystem#init(org.usfirst.frc.team2585.robot.Environment)
	 */
	@Override
	public void init(Environment environ) {
		super.init(environ);

		lowerArmMotor = new Victor(RobotMap.HIGH_FIVE_MOTOR_LOWER);
		upperArmMotor = new Victor(RobotMap.HIGH_FIVE_MOTOR_UPPER);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// Do nothing if both buttons are being pressed
		if (input.shouldHighFiveUp() && input.shouldHighFiveDown()) {
			return;
		}
		
		if (input.shouldHighFiveUp()) {
			setArmSpeed(highFiveSpeed);
		} else if (input.shouldHighFiveDown()) {
			setArmSpeed(-highFiveSpeed);
		} else {
			setArmSpeed(0);
		}
	}
	
	/**
	 * @param armSpeed the speed to set the arm motor to
	 */
	public void setArmSpeed(double armSpeed) {
		lowerArmMotor.set(armSpeed);
		upperArmMotor.set(-armSpeed/2);
	}
	
	/* (non-Javadoc)
	 * @see org.impact2585.lib2585.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		if (lowerArmMotor instanceof PWM) {
			((PWM) lowerArmMotor).free();
		}
		if (upperArmMotor instanceof PWM) {
			((PWM) upperArmMotor).free();
		}
	}

	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.systems.RobotSystem#stop()
	 */
	@Override
	public void stop() {
		setArmSpeed(0);
	}

}
