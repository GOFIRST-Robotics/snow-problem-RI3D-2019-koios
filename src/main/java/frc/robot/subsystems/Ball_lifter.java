/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Set_Intake_Height;
import frc.robot.commands.raise;

/**
 * Add your docs here.
 */
public class Ball_lifter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Solenoid lift_Solenoid;

  public Ball_lifter(){
    super("Ball_lifter");
    lift_Solenoid= new Solenoid(RobotMap.ballsolenoid);
  }

  public void put_Up(boolean up){
    lift_Solenoid.set(up);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new raise());
  }
}
