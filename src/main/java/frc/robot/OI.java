/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Extend;
import frc.robot.commands.Pop;
import frc.robot.commands.Set_Intake_Height;
import frc.robot.commands.clamp;
import frc.robot.commands.climb;

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
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

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
  public Joystick joystick = new Joystick(1);
  
  public OI(){
    //pushes out the plate popper while button is held 
    new JoystickButton(joystick,1).whileHeld(new Pop(true));
    //changes height of intake
    new JoystickButton(joystick, 5).toggleWhenPressed(new Set_Intake_Height(true));
    //pushes out plate
    new JoystickButton(joystick, 6).toggleWhenPressed(new Extend(true));

    //activates winch while held (4)
    new JoystickButton(joystick,4).whileHeld(new climb(1.00));
    //clamps/unclamps  (2)
    new JoystickButton(joystick, 2).toggleWhenPressed(new clamp());

    //prep for climb (3)
    new JoystickButton(joystick,3).whileHeld(new climb(-0.10));
  }
}
