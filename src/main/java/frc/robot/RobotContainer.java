/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDriveTwoSeconds;
import frc.robot.commands.DefaultDriveTrainCommand;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_drive_train = new DriveTrain();

  // The operator interface 
  private final XboxController m_driver_controller = new XboxController(0);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Setup the default commands for each subsystem.  The default commands are just commands that
    // are always running on the robot in the period scheduler loop.  Their execute() methods are
    // going to be called every 20ms, which will basically make this robot feel like it's a timed
    // robot, only separating the functionality into individual subsystems will hopefully help 
    // the programmers see how to compartmentalize the robot into pieces to simplify the code.
    m_drive_train.setDefaultCommand(new DefaultDriveTrainCommand(m_drive_train, m_driver_controller));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new AutoDriveTwoSeconds(m_drive_train);
  }
}
