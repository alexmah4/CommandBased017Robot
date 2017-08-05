package org.usfirst.frc.team5066.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5066.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	Joystick xboxController = new Joystick(0);
	
	Button aButton = new JoystickButton(xboxController, 1);
	Button bButton = new JoystickButton(xboxController, 2);
	Button xButton = new JoystickButton(xboxController, 3);
	Button yButton = new JoystickButton(xboxController, 4);
	Button lb = new JoystickButton(xboxController, 5);
	Button rb = new JoystickButton(xboxController, 6);
	Button back = new JoystickButton(xboxController, 7);
	Button start = new JoystickButton(xboxController, 8);
	Button l3 = new JoystickButton(xboxController, 9);
	Button r3 = new JoystickButton(xboxController, 10);
	
	public double getLS_X() {
		return xboxController.getRawAxis(0);
	}
	
	public double getLS_Y() {
		return xboxController.getRawAxis(1);
	}
	
	public double getRS_X() {
		return xboxController.getRawAxis(4);
	}
	
	public double getRS_Y() {
		return xboxController.getRawAxis(5);
	}
	
	public double getTriggerRight() {
		return xboxController.getRawAxis(3);
	}
	public double getTriggerLeft() {
		return xboxController.getRawAxis(2);
	}
	
	public OI(){
	}

	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
