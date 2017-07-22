package org.usfirst.frc.team5066.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	 public static SpeedController driveFrontLeftMotor = new CANTalon(6);
	 public static SpeedController driveMiddleLeftMotor = new CANTalon(3);
	 public static SpeedController driveRearLeftMotor = new CANTalon(2);
	 public static SpeedController driveFrontRightMotor = new CANTalon(4);
	 public static SpeedController driveMiddleRightMotor = new CANTalon(7);
	 public static SpeedController driveRearRightMotor = new CANTalon(10);
	 
	 //climber
	 public static SpeedController climberMotor = new CANTalon(5);
	 
	 //intake
	 public static SpeedController intakeMotor = new CANTalon(9);
	 
	 //low goal shooter
	 public static SpeedController lowGoalShooter = new CANTalon(8);
	 

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	 
	
	
	
	
	
	
}
