// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.drivetrain;

public class SimpleAuton extends CommandBase {
  private drivetrain drive;

  private double xSpeed;
  private double zRotation;
  private double driveSeconds;
  
  private double startTime;

  /** Creates a new SimpleAuton. */
  public SimpleAuton(drivetrain drive, double xSpeed, double zRotation, double driveSeconds) {
    this.drive = drive;
    this.xSpeed = xSpeed;
    this.zRotation = zRotation;
    this.driveSeconds = driveSeconds;

    addRequirements(drive);
  }

  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Timer.getFPGATimestamp() > startTime + driveSeconds;
  }
}
