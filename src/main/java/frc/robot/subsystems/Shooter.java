/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {
  private final VictorSPX m_motor;
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    m_motor = new VictorSPX(SHOOTER_MOTOR);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stopMotors(){
    m_motor.set(ControlMode.PercentOutput, 0);
  }

  public void shootBalls(){
    m_motor.set(ControlMode.PercentOutput, SHOOTER_SHOOT_SPEED);
  }
}
