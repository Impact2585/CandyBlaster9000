package org.usfirst.frc.team2585.robot;

import org.impact2585.lib2585.ExecuterBasedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends ExecuterBasedRobot {
	private static final long serialVersionUID = -6422460822926963853L;
	
	private Environment environ;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		environ = new Environment(this);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.IterativeRobot#teleopInit()
	 */
	@Override 
	public void teleopInit() {
		setExecuter(new TeleopExecutor(environ));
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
