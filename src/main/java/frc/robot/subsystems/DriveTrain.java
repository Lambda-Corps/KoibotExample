/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.DRIVETRAIN_LEFT_FOLLOWER;
import static frc.robot.Constants.DRIVETRAIN_LEFT_LEADER;
import static frc.robot.Constants.DRIVETRAIN_RIGHT_FOLLOWER;
import static frc.robot.Constants.DRIVETRAIN_RIGHT_LEADER;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_VictorSPX left_leader, left_follower;
  private final WPI_VictorSPX right_leader, right_follower;

  // Use the built in WPILib Differential Drive to help manage the 
  // the drivetrain functions.

  private final DifferentialDrive dt;


  /**
   * Creates a new ExampleSubsystem.
   */
  public DriveTrain() {
    left_leader = new WPI_VictorSPX(DRIVETRAIN_LEFT_LEADER);
    left_follower = new WPI_VictorSPX(DRIVETRAIN_LEFT_FOLLOWER);
    left_follower.follow(left_leader);
    // Limit the power draw of the motors to take 1/3 of a second to get to full saturation
    // This will eliminate brownouts from over drawing current
    left_leader.configOpenloopRamp(.3);
    left_follower.configOpenloopRamp(.3);
    // Invert the left sides if they need to be, we want positive numbers to move forward
    // left_leader.setInverted(true);
    // left_follower.setInverted(InvertType.FollowMaster);

    right_leader = new WPI_VictorSPX(DRIVETRAIN_RIGHT_LEADER);
    right_follower = new WPI_VictorSPX(DRIVETRAIN_RIGHT_FOLLOWER);
    right_leader.configOpenloopRamp(.3);
    right_follower.configOpenloopRamp(.3);
    right_follower.follow(right_leader);

    // Put all the motors into the WPILib differential driive to for easy
    // management of the driving
    dt = new DifferentialDrive(left_leader, right_leader);
    // The differentialdrive class automatically assumes an inversion of the 
    // right side motors, if we don't need that then just disable it.
    // dt.setRightSideInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tankDrive(double left, double right){
    dt.tankDrive(left, right);
  }

  public void stopMotors() {
    dt.tankDrive(0, 0);
  }
}
