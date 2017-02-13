package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class pushGearOutCom extends Command {
    public pushGearOutCom() {
        requires(Robot.pushGear);
    }

    protected void initialize() {
    	Robot.pushGear.pushGearOut();
    }
    
    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.pushGear.pushGearNull();
    }

    protected void interrupted() {
    	end();
    }
}