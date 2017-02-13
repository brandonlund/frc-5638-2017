package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import com.kauailabs.navx.frc.AHRS;

public class autoSquare extends CommandGroup {
	AHRS ahrs;
	double angle = ahrs.getYaw();

    public autoSquare() {
        while(RobotState.isEnabled()){
        	ahrs.reset();
        	if(angle > 0){
        		new turnLeftCom();
        	}else if(angle < 0){
        		new turnRightCom();
        	}else if(angle == 0){
	        	new driveForwardCom();
	        	Timer.delay(5);
	        	new stopCom();
        	}
        	
        	if(angle > 90){
        		new turnLeftCom();
        	}else if(angle < 90){
        		new turnRightCom();
        	}else if(angle == 90){
        		new driveForwardCom();
	        	Timer.delay(5);
	        	new stopCom();
        	}
        	
        	if(angle > 180){
        		new turnLeftCom();
        	}else if(angle < 180){
        		new turnRightCom();
        	}else if(angle == 180){
        		new driveForwardCom();
	        	Timer.delay(5);
	        	new stopCom();
        	}
        	
        	if(angle > 270){
        		new turnLeftCom();
        	}else if(angle < 270){
        		new turnRightCom();
        	}else if(angle == 270){
        		new driveForwardCom();
	        	Timer.delay(5);
	        	new stopCom();
        	}
        }
    } 
}