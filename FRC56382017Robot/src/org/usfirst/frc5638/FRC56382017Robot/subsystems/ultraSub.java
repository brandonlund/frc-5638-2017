package org.usfirst.frc5638.FRC56382017Robot.subsystems;

import org.usfirst.frc5638.FRC56382017Robot.RobotMap;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ultraSub extends Subsystem {
    private final Ultrasonic ultraSonic = RobotMap.ultraSubultraSonic;

    public void initDefaultCommand() {
    }
    
    public double wallDistance(){
    	return ultraSonic.getRangeInches();
    }
}