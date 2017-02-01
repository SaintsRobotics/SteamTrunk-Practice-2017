package com.saintsrobotics.corebot;

import com.saintsrobotics.corebot.coroutine.Task;
import com.saintsrobotics.corebot.coroutine.TaskRunner;
import com.saintsrobotics.corebot.input.OI;
import com.saintsrobotics.corebot.input.PracticeSensors;
import com.saintsrobotics.corebot.input.Sensors;
import com.saintsrobotics.corebot.output.CompetitionBotMotors;
import com.saintsrobotics.corebot.output.Motors;
import com.saintsrobotics.corebot.output.Servos;
import com.saintsrobotics.corebot.tasks.UpdateMotors;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

    public static double MOTOR_RAMPING = 0.05;

    public static double GEAR_DROPPER_OUT = 90;
    public static double GEAR_DROPPER_IN = 65;

    public static double RIGHT_SHIFTER_OUT = 78;
    public static double RIGHT_SHIFTER_IN = 108;

    public static double LEFT_SHIFTER_OUT = 76;
    public static double LEFT_SHIFTER_IN = 56;

    private SendableChooser<Task> taskChooser = new SendableChooser<>();
    public static NetworkTable visionTable;
    public static Preferences prefs;

    public static Sensors sensors = new PracticeSensors();
    public static Motors motors = new CompetitionBotMotors();
    public static Servos servos = new Servos(9, 8, 7);
    public static OI oi = new OI();

    private UsbCamera camera;
    public static int cameraWidth;
    public static int cameraHeight;

    private TaskRunner teleopRunner;
    private TaskRunner autonomousRunner;
    private TaskRunner testRunner;

    @Override
    public void robotInit() {
        sensors.init();
        motors.init();
        servos.init();
        oi.init();
    }


    @Override
    public void teleopInit() {
        teleopRunner = new TaskRunner(
                new UpdateMotors()
        );
    }

    @Override
    public void autonomousInit() {
        autonomousRunner = new TaskRunner(
                new UpdateMotors()
        );
    }

    @Override
    public void testInit() {
        testRunner = new TaskRunner(
                new UpdateMotors()
        );
    }

    @Override
    public void teleopPeriodic() {
        teleopRunner.run();
    }

    @Override
    public void autonomousPeriodic() {
        autonomousRunner.run();
    }

    @Override
    public void testPeriodic() {
        testRunner.run();
    }

    @Override
    public void disabledInit() {
        if (teleopRunner != null) {
            teleopRunner.disable();
        }
        if (autonomousRunner != null) {
            autonomousRunner.disable();
        }
        if (testRunner != null) {
            testRunner.disable();
        }
        motors.stopAll();
    }

    @Override
    public void disabledPeriodic() {

    }
}
