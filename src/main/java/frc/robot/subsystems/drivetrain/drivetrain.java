// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;
  private DifferentialDrive m_myRobot;

  public void Init() {
    frontLeft = new WPI_TalonSRX(10);
    frontRight = new WPI_TalonSRX(11);
    backLeft = new WPI_TalonSRX(12);
    backRight = new WPI_TalonSRX(13);
    frontLeft.setInverted(true);
    backLeft.setInverted(true);
    frontLeft.follow(backLeft);
    frontRight.follow(backRight);
    m_myRobot = new DifferentialDrive(backLeft, backRight);
  }
  public drivetrain() {
  
  }
public void setLeftspeed(){
  backLeft.set(ControlMode.PercentOutput, 1);
  
}
public void setRightspeed(){
  backRight.set(ControlMode.PercentOutput, 1);
  
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
