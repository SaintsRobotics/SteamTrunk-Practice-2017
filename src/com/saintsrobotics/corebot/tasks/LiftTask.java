package com.saintsrobotics.corebot.tasks;

import com.saintsrobotics.corebot.Robot;
import com.saintsrobotics.corebot.coroutine.RunEachFrameTask;

public class LiftTask extends RunEachFrameTask {

	@Override
	protected void runEachFrame() {
		double amount = Robot.oi.drive.axes.rightTrigger() - Robot.oi.drive.axes.leftTrigger();
		Robot.motors.liftMotors.set(amount);

	}

}
