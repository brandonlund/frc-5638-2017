package org.usfirst.frc5638.FRC56382017Robot.commands;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class strafeRightCom extends Command {
    public strafeRightCom() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.strafeRight(.25);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}