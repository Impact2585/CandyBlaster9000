package org.usfirst.frc.team2585.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc.team2585.input.InputMethod;
import org.usfirst.frc.team2585.systems.CandyShooterSystem;

/**
 * Unit Tests for the candy shooter system
 */
public class CandyShooterSystemTest {
	private TestInput input;
	private TestCandyShooterSystem candyShooterSystem;
	
	boolean shouldShootCandyInput;
	
	double shooterSpeedOutput;
	
	/**
	 * Create new input and candy shooter system for testing
	 */
	@Before
	public void setUp() {
		input = new TestInput();
		candyShooterSystem = new TestCandyShooterSystem();
		candyShooterSystem.setInput(input);
	}
	
	/**
	 * Tests that the speed of the motor is more than 0
	 * when the shoot button is pressed
	 */
	@Test
	public void motorRunsWhenShooting() {
		shouldShootCandyInput = true;
		candyShooterSystem.run();
		Assert.assertTrue(shooterSpeedOutput > 0);
	}
	
	/**
	 * Tests that the speed of the motor starts as zero when the 
	 * user gives no input
	 */
	@Test
	public void defaultsToZero() {
		shouldShootCandyInput = false;
		candyShooterSystem.run();
		Assert.assertTrue(shooterSpeedOutput == 0);
	}
	
	
	/**
	 * Tests that the output returns to zero after releasing the "shoot" button
	 */
	@Test
	public void returnsToZeroAfterUp() {
		shouldShootCandyInput = true;
		candyShooterSystem.run();
		shouldShootCandyInput = false;
		candyShooterSystem.run();
		
		Assert.assertTrue(shooterSpeedOutput==0);
	}
	
	/**
	 * Testable input for the high five system tests
	 */
	private class TestInput extends InputMethod {
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.input.InputMethod#shouldHighFiveUp()
		 */
		@Override
		public boolean shouldShoot() {
			return shouldShootCandyInput;
		}
		
	}
	
	/**
	 * A testable High Five System
	 */
	/**
	 * A testable High Five System
	 */
	private class TestCandyShooterSystem extends CandyShooterSystem {
		
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.systems.HighFiveSystem#setArmSpeed(double)
		 */
		@Override
		public void setMotorSpeed(double candyMotorSpeed) {
			shooterSpeedOutput = candyMotorSpeed;
		}
	}
}
