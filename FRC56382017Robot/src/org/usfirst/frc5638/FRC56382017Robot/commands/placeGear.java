package org.usfirst.frc5638.FRC56382017Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5638.FRC56382017Robot.Robot;

public class placeGear extends CommandGroup {
    public placeGear() {
    	if(Robot.ultraSub.wallDistance() < 8){
    		addSequential(new servoComUp());
    		Timer.delay(.5);
    		addSequential(new pushGearOutCom());
    		Timer.delay(.5);
    		addSequential(new pushGearInCom());
    		Timer.delay(.5);
    		addSequential(new servoComDown());
    	}
    } 
}