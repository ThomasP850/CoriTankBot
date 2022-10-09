// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backRight;

  @Override
  public void robotInit() {
    frontLeft= new WPI_TalonSRX (10);
    backLeft= new WPI_TalonSRX (13);
    frontRight= new WPI_TalonSRX (11);
    backRight= new WPI_TalonSRX (12);
    frontLeft.setInverted(true);
    backLeft.setInverted(true);
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    m_myRobot= new DifferentialDrive(frontLeft, frontRight);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
