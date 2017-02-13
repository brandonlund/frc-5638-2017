package org.usfirst.frc5638.FRC56382017Robot;

import org.usfirst.frc5638.FRC56382017Robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;

public class OI {
	
    public JoystickButton winchUp;
    public JoystickButton winchDown;
    public JoystickButton servoButtonUp;
    public JoystickButton servoButtonDown;
    public JoystickButton placeGearButton;
    public XboxController xbox;
    
    public OI() {
    	xbox = new XboxController(0);
        //start deadzone
    	if(xbox.getRawAxis(1) < 0.2 || xbox.getRawAxis(1) > -0.2){
        	RobotMap.driveTrainfrontLeft.set(0);
        	RobotMap.driveTrainrearLeft.set(0);
        	RobotMap.driveTrainfrontRight.set(0);
        	RobotMap.driveTrainrearRight.set(0);
        }
    	
        if(xbox.getRawAxis(4) < 0.2 || xbox.getRawAxis(4) > -0.2){
        	RobotMap.driveTrainfrontLeft.set(0);
        	RobotMap.driveTrainrearLeft.set(0);
        	RobotMap.driveTrainfrontRight.set(0);
        	RobotMap.driveTrainrearRight.set(0);
        }
        
        if(xbox.getRawAxis(0) < 0.2 || xbox.getRawAxis(0) > -0.2){
        	RobotMap.driveTrainfrontLeft.set(0);
        	RobotMap.driveTrainrearLeft.set(0);
        	RobotMap.driveTrainfrontRight.set(0);
        	RobotMap.driveTrainrearRight.set(0);
        }
        //end deadzone
        //buttons
        placeGearButton = new JoystickButton(xbox, 10); //wont work... will send warning to ds
        placeGearButton.whenPressed(new placeGear());
        servoButtonDown = new JoystickButton(xbox, 1);
        servoButtonDown.whenPressed(new servoComDown());
        servoButtonUp = new JoystickButton(xbox, 3);
        servoButtonUp.whenPressed(new servoComUp());
        winchDown = new JoystickButton(xbox, 10);
        winchDown.whileHeld(new winchDownCom());
        winchUp = new JoystickButton(xbox, 6);
        winchUp.whileHeld(new winchUpCom());

        //SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("driveWithJoystick", new driveWithJoystick());
        SmartDashboard.putData("winchUpCom", new winchUpCom());
        SmartDashboard.putData("winchDownCom", new winchDownCom());
        SmartDashboard.putData("pushGearOutCom", new pushGearOutCom());
        SmartDashboard.putData("pushGearInCom", new pushGearInCom());
        SmartDashboard.putData("servoComUp", new servoComUp());
        SmartDashboard.putData("servoComDown", new servoComDown());
        SmartDashboard.putData("visionCom", new visionCom());
        SmartDashboard.putData("driveForwardStrafeRightTest", new driveForwardStrafeRightTest());
        SmartDashboard.putData("placeGear", new placeGear());
    }
    
    public XboxController getXbox1() {
    	return xbox;
    }
}