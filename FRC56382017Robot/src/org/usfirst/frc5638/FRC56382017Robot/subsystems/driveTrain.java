package org.usfirst.frc5638.FRC56382017Robot.subsystems;

import org.usfirst.frc5638.FRC56382017Robot.Robot;
import org.usfirst.frc5638.FRC56382017Robot.RobotMap;
import org.usfirst.frc5638.FRC56382017Robot.commands.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class driveTrain extends Subsystem {
	AHRS ahrs;
	
    private final SpeedController frontRight = RobotMap.driveTrainfrontRight;
    private final SpeedController frontLeft = RobotMap.driveTrainfrontLeft;
    private final SpeedController rearRight = RobotMap.driveTrainrearRight;
    private final SpeedController rearLeft = RobotMap.driveTrainrearLeft;
    private final RobotDrive driveMotors = RobotMap.driveTraindriveMotors;

    public void initDefaultCommand() {
        setDefaultCommand(new driveWithJoystick());
        
        try{
        	ahrs = new AHRS(SPI.Port.kMXP);
        }catch(RuntimeException ex){
        	DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(), true);
        }
    }
    
    public void drive(XboxController getXbox1){
		driveMotors.mecanumDrive_Cartesian(getXbox1.getRawAxis(0), getXbox1.getRawAxis(1), getXbox1.getRawAxis(4), ahrs.getYaw());
		
	    if(Robot.oi.xbox.getRawButton(2) == true){
	    	ahrs.zeroYaw();
	    }
	    
	    SmartDashboard.putNumber("Gyro Yaw", ahrs.getYaw());
    }
    
    public void stop(){
    	frontLeft.set(0);
    	frontRight.set(0);
    	rearRight.set(0);
    	rearLeft.set(0);
    }
    
    public void driveForward(double speed){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(speed); //.25
    	frontRight.set(speed); //.25
    	rearRight.set(speed); //.25
    	rearLeft.set(speed);//.25
    }
    
    public void driveBackward(double speed){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-speed);//-.25
    	frontRight.set(-speed);//-.25
    	rearRight.set(-speed);//-.25
    	rearLeft.set(-speed);//-.25
    }
    
    public void turnLeft(double speed){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-speed);//-.3
    	frontRight.set(speed);//.3
    	rearRight.set(speed);//.3
    	rearLeft.set(-speed);//-.3
    }
    
    public void turnRight(double speed){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(speed);//.3
    	frontRight.set(-speed);//-.3
    	rearRight.set(-speed);//-.3
    	rearLeft.set(speed);//.3
    }
    
    public void strafeLeft(double speed){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(speed);//.25
    	frontRight.set(-speed);//-.25
    	rearRight.set(speed);//.25
    	rearLeft.set(-speed);//-.25
    }
    
    public void strafeRight(double speed){
    	driveMotors.setSafetyEnabled(false);
    	frontLeft.set(-speed);//-.25
    	frontRight.set(speed);//.25
    	rearRight.set(-speed);//-.25
    	rearLeft.set(speed);//.25
    }
}