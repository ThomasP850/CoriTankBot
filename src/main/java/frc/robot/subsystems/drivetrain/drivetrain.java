// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drivetrain.commands.DriveCommand;

public class drivetrain extends SubsystemBase {

  /** Creates a new drivetrain. */
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;
  private DifferentialDrive m_myRobot;

  private MotorControllerGroup leftMotorGroup;
  private MotorControllerGroup rightMotorGroup;

  public void Init() {
    frontLeft = new WPI_TalonSRX(10);
    frontRight = new WPI_TalonSRX(11);
    backLeft = new WPI_TalonSRX(13);
    backRight = new WPI_TalonSRX(12);

    frontRight.setInverted(true);
    backRight.setInverted(true);

    leftMotorGroup = new MotorControllerGroup(backLeft, frontLeft);
    rightMotorGroup = new MotorControllerGroup(backRight, frontRight);

    m_myRobot = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

    setDefaultCommand(new DriveCommand(this));

    Shuffleboard.getTab("Drive").addNumber("Front left speed", frontLeft::getSelectedSensorVelocity);
    Shuffleboard.getTab("Drive").addNumber("Back left speed", backLeft::getSelectedSensorVelocity);
  }

  /**
   * Send a signal to the robot's drivetrain
   * 
   * @param xSpeed The speed to travel in the positive x direction as a percent, [-1, 1]
   * @param zRotation The rotation speed in the counterclockwise direction as a percent, [-1, 1]
   */
  public void arcadeDrive(double xSpeed, double zRotation) {
    m_myRobot.arcadeDrive(xSpeed, zRotation);
  }

  /**
   * Stop the drivetrain
   */
  public void stop() {
    m_myRobot.arcadeDrive(0, 0);
  }

}
