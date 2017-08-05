package org.usfirst.frc.team5066.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5066.robot.subsystems.SpeedMode;
import org.usfirst.frc.team5066.robot.RobotMap;
import com.ctre.CANTalon;

public class Chassis extends Subsystem{
	
	private double DEFAULT_MINIMUM_THRESHOLD = 0.09;
	private double velocityMultiplier = 1.0;
	private final static double DEFAULT_SLOW_SPEED_CONSTANT = 0.5;
	private final static double DEFAULT_NORMAL_SPEED_CONSTANT = 0.8;
	private final static double DEFAULT_FAST_SPEED_CONSTANT = 1.0;
	
	double slowSpeedConstant = DEFAULT_SLOW_SPEED_CONSTANT;
	double normalSpeedConstant = DEFAULT_NORMAL_SPEED_CONSTANT;
	double fastSpeedConstant = DEFAULT_FAST_SPEED_CONSTANT;
	
	CANTalon frontLeftMotor = (CANTalon) RobotMap.driveFrontLeftMotor;
	CANTalon middleLeftMotor = (CANTalon) RobotMap.driveMiddleLeftMotor;
	CANTalon rearLeftMotor = (CANTalon) RobotMap.driveRearLeftMotor;
	CANTalon frontRightMotor = (CANTalon) RobotMap.driveFrontRightMotor;
	CANTalon middleRightMotor = (CANTalon) RobotMap.driveMiddleRightMotor;
	CANTalon rearRightMotor = (CANTalon) RobotMap.driveRearRightMotor;

		
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	private double threshold(double velocity) {
		if (Math.abs(velocity) <= DEFAULT_MINIMUM_THRESHOLD) {
			return 0;
		}
		return velocity;
	}
	
	public void driveForward(){
		frontLeftMotor.set(0.5);
		middleLeftMotor.set(0.5);
		rearLeftMotor.set(0.5);
		frontRightMotor.set(0.5);
		middleRightMotor.set(0.5);
		rearRightMotor.set(0.5);
	}
	
	public void turnFLMotor(double speed){
		frontLeftMotor.set(speed);
	}
	
	public void turnMLMotor(double speed){
		middleLeftMotor.set(speed);
	}
	
	public void turnRLMotor(double speed){
		rearLeftMotor.set(speed);
	}
	
	public void turnFRMotor(double speed){
		frontRightMotor.set(speed);
	}
	
	public void turnMRMotor(double speed){
		middleRightMotor.set(speed);
	}
	
	public void turnRRMotor(double speed){
		rearRightMotor.set(speed);
	}
	
	public void arcadeSixWheel(double translation, double rotation, boolean squaredInputs, SpeedMode speedMode) {
		double translationVelocity = translation, rotationVelocity = rotation;
		
		translationVelocity = threshold(translationVelocity);
		rotationVelocity = threshold(rotationVelocity);
		
		setVelocityMultiplierBasedOnSpeedMode(speedMode);
		
		// Do squared inputs if necessary
		if (squaredInputs) {
			translationVelocity *= Math.abs(translation);
			rotationVelocity *= Math.abs(rotation);
		}
		
		// Do reverse drive when necessary. There are methods above for different inputs.
		/*if (reverse) {
			translationVelocity = -translationVelocity;
			rotationVelocity = -rotationVelocity;
		}
		*/
		// Guard against illegal values
		double maximum = Math.max(1, Math.abs(translationVelocity) + Math.abs(rotationVelocity));

		
		translationVelocity = threshold(translationVelocity);
		rotationVelocity = threshold(rotationVelocity);

		// Set the motors
		frontLeftMotor.set(this.velocityMultiplier * ((-translationVelocity + rotationVelocity) / maximum));
		rearLeftMotor.set(this.velocityMultiplier * ((-translationVelocity + rotationVelocity) / maximum));
		middleLeftMotor.set(this.velocityMultiplier * ((-translationVelocity + rotationVelocity) / maximum));
		middleRightMotor.set(this.velocityMultiplier * ((translationVelocity + rotationVelocity) / maximum));
		frontRightMotor.set(this.velocityMultiplier * ((translationVelocity + rotationVelocity) / maximum));
		rearRightMotor.set(this.velocityMultiplier * ((translationVelocity + rotationVelocity) / maximum));
		//SmartDashboard.putNumber("rightEncoder", ((CANTalon) m_rightMiddleMotor).getEncPosition());
		//SmartDashboard.putNumber("leftEncoder", ((CANTalon) m_leftMiddleMotor).getEncPosition());
	}
	
private void setVelocityMultiplierBasedOnSpeedMode(SpeedMode speedMode) {
		
		switch(speedMode) {
		case SLOW:
			velocityMultiplier = this.slowSpeedConstant;
			SmartDashboard.putString("DB/String 8", "Using slow speed constant");
			break;
		case NORMAL:
			velocityMultiplier = this.normalSpeedConstant;
			SmartDashboard.putString("DB/String 8", "Using normal speed constant");
			break;
		case FAST:
			velocityMultiplier = this.fastSpeedConstant;
			SmartDashboard.putString("DB/String 8", "Using fast speed constant");
			break;
		}
	}
	
	public void stop(){
		frontLeftMotor.set(0);
		middleLeftMotor.set(0);
		rearLeftMotor.set(0);
		frontRightMotor.set(0);
		middleRightMotor.set(0);
		rearRightMotor.set(0);
	}

}
