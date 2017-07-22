package org.usfirst.frc.team5066.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5066.robot.RobotMap;

import com.ctre.CANTalon;

public class Chassis extends Subsystem{
	
	SpeedController frontLeftMotor = RobotMap.driveFrontLeftMotor;
	SpeedController middleLeftMotor = RobotMap.driveMiddleLeftMotor;
	SpeedController rearLeftMotor = RobotMap.driveRearLeftMotor;
	SpeedController frontRightMotor = RobotMap.driveFrontRightMotor;
	SpeedController middleRightMotor = RobotMap.driveMiddleRightMotor;
	SpeedController rearRightMotor = RobotMap.driveRearRightMotor;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void driveForward(){
		frontLeftMotor.set(0.5);
		middleLeftMotor.set(0.5);
		rearLeftMotor.set(0.5);
		frontRightMotor.set(0.5);
		middleRightMotor.set(0.5);
		rearRightMotor.set(0.5);
	}
	
	public void stop(){
		
	}

}
