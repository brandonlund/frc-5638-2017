package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;

public class rotateZero extends Command {
    public rotateZero() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	AHRS ahrs = null;
    	if(ahrs.getYaw() < 0 || ahrs.getYaw() < 0){
    		new turnRightCom();
    	}else if(ahrs.getYaw() > 0){
    		new turnLeftCom();
    	}else if(ahrs.getYaw() == 0){
    		new stopCom();
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	AHRS ahrs = null;
    	if(ahrs.getYaw() == 0 || ahrs.getYaw() == 0){
    		return true;
    	}else{
        return false;
    	}
    }

    protected void end() {
    	new stopCom();
    }

    protected void interrupted() {
    	end();
    }
}