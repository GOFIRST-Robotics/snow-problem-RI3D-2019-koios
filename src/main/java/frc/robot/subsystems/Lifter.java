/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.climb;

/**
 * Add your docs here.
 */
public class Lifter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSP main_lift;
  private VictorSP main_lift_2;

  public Lifter() {
    super("Lifter");
    main_lift= new VictorSP(RobotMap.mainlift);
    main_lift_2= new VictorSP(RobotMap.mainlift2);
  }

  public void stop(){
    main_lift.set(0);
    main_lift_2.set(0);
  }

  public void set_Speed(double speed){
    main_lift.set(speed);
    main_lift_2.set(-speed);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new climb(0.0));
  }
}
