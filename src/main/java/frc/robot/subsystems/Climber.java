/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.CLIMBER_LOWER_SPEED;
import static frc.robot.Constants.CLIMBER_MOTOR;
import static frc.robot.Constants.CLIMBER_RAISE_SPEED;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  
  private final VictorSPX m_motor;
  /**
   * Creates a new Climber.
   */
  public Climber() {
    m_motor = new VictorSPX(CLIMBER_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void raiseClimber(){
    // Drive it toward the up position
    m_motor.set(ControlMode.PercentOutput, CLIMBER_RAISE_SPEED);
  }

  public void lowerClimber(){
    m_motor.set(ControlMode.PercentOutput, CLIMBER_LOWER_SPEED);
  }

  public void stopMotors(){
    m_motor.set(ControlMode.PercentOutput, 0);
  }
}
