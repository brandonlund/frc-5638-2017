package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class servoComDown extends Command {
    public servoComDown() {
        requires(Robot.servoMotors);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.servoMotors.servoDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.servoMotors.servoStop();
    }

    protected void interrupted() {
    	end();
    }
}