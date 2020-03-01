/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Motor Controllers Mappings
    public static final int DRIVETRAIN_LEFT_LEADER = 1;
    public static final int DRIVETRAIN_LEFT_FOLLOWER = 2;
    public static final int DRIVETRAIN_RIGHT_LEADER= 3;
    public static final int DRIVETRAIN_RIGHT_FOLLOWER = 4;
    public static final int CLIMBER_MOTOR = 5;
    public static final int LIFTER_MOTOR = 6;
    public static final int SHOOTER_MOTOR = 7;
    public static final int SUBSYSTEM_2_MOTOR = 8;

    // Climber related Contants
    public static final double CLIMBER_RAISE_SPEED = 0.5;
    public static final double CLIMBER_LOWER_SPEED = -0.5;

    // Intake related Constants
    public static final double INTAKE_PICKUP_SPEED = 0.5;

    // Shooter related Constants
    public static final double SHOOTER_SHOOT_SPEED = 0.5;
}
