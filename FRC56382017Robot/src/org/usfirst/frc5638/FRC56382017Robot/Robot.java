package org.usfirst.frc5638.FRC56382017Robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc5638.FRC56382017Robot.commands.*;
import org.usfirst.frc5638.FRC56382017Robot.subsystems.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static driveTrain driveTrain;
    public static winch winch;
    public static pushGear pushGear;
    public static servoMotors servoMotors;
    public static ultraSub ultraSub;

    SendableChooser<Object> autonomousModes;
    
    public void robotInit() {
    	RobotMap.init();
        driveTrain = new driveTrain();
        winch = new winch();
        pushGear = new pushGear();
        servoMotors = new servoMotors();
        ultraSub = new ultraSub();
        oi = new OI();

        autonomousCommand = new AutonomousCommand();

        autonomousModes = new SendableChooser<Object>();
        
        autonomousModes.addDefault("only vision--JUST A TEST", new visionCom());
        autonomousModes.addObject("drive strafe right--JUST A TEST", new driveForwardStrafeRightTest());
        autonomousModes.addObject("Drive in a Square--JUST A TEST", new autoSquare());
        autonomousModes.addObject("Right Side Vision", new driveRightVision());
        autonomousModes.addObject("Left Side Vision", new driveLeftVision());
        autonomousModes.addObject("Middle to Right Side of Baseline", new rightBaseline());
        autonomousModes.addObject("Middle to Left Side of Baseline", new leftBaseline());
        autonomousModes.addObject("Middle to Middle Peg to Right of Baseline", new midGearRight());
        autonomousModes.addObject("Middle to Middle Peg to Left of Baseline", new MidGearLeft());
        autonomousModes.addObject("Drive Straight Through Baseline", new baseLine());
        autonomousModes.addObject("Do Nothing", new AutonomousCommand());
        SmartDashboard.putData("Auto Modes", autonomousModes);
    }

    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autonomousModes.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
    
    CameraServer server;
    
    public Robot(){
    	server = CameraServer.getInstance();
    	server.startAutomaticCapture("cam0", 0);
    }
}