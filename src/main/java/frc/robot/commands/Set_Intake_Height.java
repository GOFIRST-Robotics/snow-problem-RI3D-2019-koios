/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Set_Intake_Height extends Command {
  boolean height;
  int i = 1;
  Timer t =new Timer();
  public Set_Intake_Height(boolean high) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_Ball_lifter);
    requires(Robot.m_Disc_Extender);
    this.height=high;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    t.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if (t.get()>.6){
      Robot.m_Ball_lifter.put_Up(height);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
