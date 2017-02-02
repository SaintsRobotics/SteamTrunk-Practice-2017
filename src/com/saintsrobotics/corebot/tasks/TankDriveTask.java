package com.saintsrobotics.corebot.tasks;

import com.saintsrobotics.corebot.Robot;
import com.saintsrobotics.corebot.coroutine.RunEachFrameTask;

public class TankDriveTask extends RunEachFrameTask {
	protected void runEachFrame() {
		double leftValue = Robot.oi.drive.axes.leftStickX();
		double rightValue = Robot.oi.drive.axes.rightStickY();
		double coefficient = 0.75 + 0.25*(Robot.oi.drive.axes.rightTrigger()) - 0.25*(Robot.oi.drive.axes.leftTrigger());
		leftValue *= coefficient;
		rightValue *= coefficient;
		Robot.motors.leftMotors.set(leftValue);
		Robot.motors.rightMotors.set(rightValue);
	}
}
