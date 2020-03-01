/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDriveTwoSeconds extends CommandBase {
  private final DriveTrain m_dt;
  private final Timer timer;
  /**
   * Creates a new AutoDriveTwoSeconds.
   */
  public AutoDriveTwoSeconds(DriveTrain dt) {
    m_dt = dt;
    // Use addRequirements() here to declare subsystem dependencies.
    // Tell the scheduler that this command will use the DriveTrain so 
    // the default command won't be running and ruining our driving
    // during auto
    addRequirements(m_dt);

    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // We don't want to go far, just move off the line, so only 25% motors
    m_dt.tankDrive(.25, .25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_dt.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > 2;
  }
}
