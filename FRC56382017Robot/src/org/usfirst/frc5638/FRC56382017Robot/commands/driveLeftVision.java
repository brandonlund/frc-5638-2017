package org.usfirst.frc5638.FRC56382017Robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class driveLeftVision extends CommandGroup {
	AHRS ahrs;
	
    public driveLeftVision() {
    	ahrs.reset();
    	addSequential(new driveForwardCom());
        Timer.delay(3);
        addSequential(new stopCom());
        Timer.delay(.1);
        addSequential(new rotateNegSixty());
        Timer.delay(1);
        addSequential(new stopCom());
        Timer.delay(.1);
        addSequential(new visionCom());
        Timer.delay(5);
        addSequential(new placeGear());
        Timer.delay(.1);
        addSequential(new driveBackCom());
        Timer.delay(1);
        addSequential(new stopCom());
        Timer.delay(.1);
        addSequential(new rotateZero());
        Timer.delay(1);
        addSequential(new stopCom());
        Timer.delay(.1);
        addSequential(new driveForwardCom());
        Timer.delay(1);
        addSequential(new stopCom());
        ahrs.reset();
    }
}