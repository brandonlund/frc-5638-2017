package org.usfirst.frc5638.FRC56382017Robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class baseLine extends CommandGroup {
	AHRS ahrs;

    public baseLine() {
    	ahrs.reset();
        addSequential(new driveForwardCom());
        Timer.delay(6);
        addSequential(new stopCom());
        ahrs.reset();
    }
}