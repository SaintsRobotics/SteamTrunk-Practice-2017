package com.saintsrobotics.corebot.tasks;

import com.saintsrobotics.corebot.coroutine.Task;
import com.saintsrobotics.corebot.Robot;

//switch to 90 degrees after pressing A
public class DropperTask extends Task {
	public void run(){
		Robot.servos.gearDropArm.setAngle(45.0);
		while (true) {
			wait.until(() -> Robot.oi.drive.buttons.A());
			Robot.servos.gearDropArm.setAngle(90.0);
			wait.forSeconds(5.0);
			Robot.servos.gearDropArm.setAngle(45.0);
		}
		
	}
	
}
