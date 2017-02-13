package org.usfirst.frc5638.FRC56382017Robot.commands;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc5638.FRC56382017Robot.Robot;
import org.usfirst.frc5638.FRC56382017Robot.RobotMap;

public class visionCom extends Command {
    public visionCom() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	int IMG_WIDTH = 640;
        int IMG_HEIGHT = 480;

        while(RobotState.isEnabled()){
        	NetworkTable table;
        	table = NetworkTable.getTable("GRIP/myContoursReport");
	        double[] defaultValue = new double[0];
	        double[] x = table.getNumberArray("centerX", defaultValue);
	        double[] y = table.getNumberArray("centerY", defaultValue);
	        double[] h = table.getNumberArray("height", defaultValue);
	        double[] w = table.getNumberArray("width", defaultValue);
	        double[] a = table.getNumberArray("area", defaultValue);
        
	        RobotMap.driveTraindriveMotors.setSafetyEnabled(false);
	        
		    try{
		        if(a.length == 2 && x.length == 2){
		        	double centerX = (x[0] + x[1])/2;
		        	double totalArea = a[0] + a[1];
			        
		        	if(centerX > 360 && x.length == 2){
				        System.out.println("TURNING RIGTH");
				        new turnRightCom();
				        //Robot.driveTrain.turnRight();								CLEAN UP
				        Timer.delay(.1);
				    }else if(centerX < 280 && x.length == 2){
				        System.out.println("TURNING LEFT");
				        new turnLeftCom();
				        //Robot.driveTrain.turnLeft();								CLEAN UP
				        Timer.delay(.1);
				    }else if(x.length < 2 || x.length > 2){
				    	System.out.println("no x values or too many x values");
				    	Timer.delay(.1);
				    }else if(totalArea > 1000 && totalArea < 9000){
				        System.out.println("DRIVING FORWARD");
				        new driveForwardCom();
				        //Robot.driveTrain.driveForward();							CLEAN UP
				        Timer.delay(.1);
				    }else if(totalArea > 10000){
				        System.out.println("DRIVING BACKWARD");
				        new driveBackCom();
				        //Robot.driveTrain.driveBackward();							CLEAN UP
				        Timer.delay(.1);
				    }else if(a.length != 2){
				        System.out.println("area array has more than or less than 2 values");
				        Timer.delay(.5);
				    }else{
				    	System.out.println("robot stopped");
				    	new stopCom();
				    	//Robot.driveTrain.stop();									CLEAN UP
				    	Timer.delay(.1);
				    }
			        
				    if(totalArea < 2000 || totalArea > 11000){
				        System.out.println("STOPPED");
				        new stopCom();
				        //Robot.driveTrain.stop();									CLEAN UP
				    }
				}
		    }
		    
	        catch(ArrayIndexOutOfBoundsException ex){
	        	System.out.println("Goal not found. TURNING LEFT IN ORDER FIND GOAL");
	        	new turnLeftCom();
	        	Timer.delay(1);
	        }finally{
	        	new stopCom();
		        end();
		    }
	    }
	}

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}