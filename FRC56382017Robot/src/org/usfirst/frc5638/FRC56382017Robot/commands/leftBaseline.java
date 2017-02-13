package org.usfirst.frc5638.FRC56382017Robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class leftBaseline extends CommandGroup {
	AHRS ahrs;

    public leftBaseline() {
    	ahrs.reset();
    	addSequential(new driveForwardCom());
        Timer.delay(6);
        addSequential(new stopCom());
        addSequential(new rotateNegNinety());
        addSequential(new driveForwardCom());
        Timer.delay(2);
        addSequential(new rotateZero());
        addSequential(new driveForwardCom());
        Timer.delay(3);
        addSequential(new stopCom());
        ahrs.reset();
    }
}