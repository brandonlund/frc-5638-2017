package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class driveForwardStrafeRightTest extends Command {
    public driveForwardStrafeRightTest() {
    	requires(Robot.driveTrain);
    }
    
    protected void initialize(){
    	Robot.driveTrain.driveForward(.25);
    	Timer.delay(10);
    	Robot.driveTrain.strafeRight(.25);
    	Timer.delay(10);
    	Robot.driveTrain.stop();
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	Robot.driveTrain.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}