/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DifferentialDrive drivetrain;
  private VictorSP[] talons;
  private SpeedControllerGroup m_Right;
  private SpeedControllerGroup m_Left;
  public VictorSP[] getTalons() {
		return talons;
  }

  public Drivetrain() {
		super("Drivetrain");
		initTalonsConfig();
  }

  private void initTalonsConfig() {
		talons = new VictorSP[] { new VictorSP(RobotMap.frontleftmotor),
				new VictorSP(RobotMap.rearleftmotor), new VictorSP(RobotMap.frontrightmotor),
				new VictorSP(RobotMap.rearrightmotor) };

    m_Right= new SpeedControllerGroup(talons[2], talons[3]);
    m_Left= new SpeedControllerGroup(talons[0], talons[1]);

		drivetrain = new DifferentialDrive(m_Left, m_Right);
  }
  public void drive(double l, double r){
    drivetrain.tankDrive(l, r);
    SmartDashboard.putNumber("r", r);
    SmartDashboard.putNumber("l", l);
  }

  public void drive(Joystick joy){
    double r=joy.getRawAxis(5);
    double l=joy.getRawAxis(1);
    drive(l,r);
  }
  
  public void _StAAahP(){
    for (VictorSP t : talons) {
      t.set(0);
    } 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}
