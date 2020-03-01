/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class DefaultDriveTrainCommand extends CommandBase {
  private final DriveTrain m_drive_train;
  private final XboxController m_controller;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DefaultDriveTrainCommand(DriveTrain subsystem, XboxController remote) {
    m_controller = remote;
    m_drive_train = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive_train);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // The axis is inverted, so to make the "up" direction drive forward, multiply by negative one
    double left_speed = m_controller.getY() * -1; 
    double right_speed = m_controller.getRawAxis(4) * -1;

    m_drive_train.tankDrive(left_speed, right_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // The default command should never end so always return false
  @Override
  public boolean isFinished() {
    return false;
  }
}
