package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class midGearRight extends CommandGroup {
    public midGearRight() {
    	addSequential(new visionCom());
    	Timer.delay(5);
    	addSequential(new stopCom());
    	addSequential(new placeGear());
    	addSequential(new driveBackCom());
    	Timer.delay(1);
    	addSequential(new rotatePosNinety());
    	addSequential(new driveForwardCom());
    	Timer.delay(3);
    	addSequential(new rotateZero());
    	addSequential(new driveForwardCom());
    	Timer.delay(2);
    	addSequential(new stopCom());
    }
}