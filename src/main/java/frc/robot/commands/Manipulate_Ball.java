/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Manipulate_Ball extends Command {
  public Manipulate_Ball() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_Ball_Buster);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_Ball_Buster.spit(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double in = Robot.m_oi.joystick.getRawAxis(2);
    double out = Robot.m_oi.joystick.getRawAxis(3);
    Robot.m_Ball_Buster.spit(in-out);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_Ball_Buster.spit(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
