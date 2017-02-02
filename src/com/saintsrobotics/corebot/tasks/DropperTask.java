package com.saintsrobotics.corebot.tasks;

import com.saintsrobotics.corebot.coroutine.RunContinuousTask;
import com.saintsrobotics.corebot.coroutine.Task;
import com.saintsrobotics.corebot.Robot;

//switch to 90 degrees after pressing A
public class DropperTask extends RunContinuousTask {
	public DropperTask() {
		Robot.servos.gearDropArm.setAngle(45.0);
	}
	@Override
	protected void runContinuously() {
		wait.until(() -> Robot.oi.drive.buttons.A());
		Robot.servos.gearDropArm.setAngle(90.0);
		wait.forSeconds(5.0);
		Robot.servos.gearDropArm.setAngle(45.0);		
	}
	
}
