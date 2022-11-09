// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.Drive;

public class Robot extends TimedRobot {
  private Joystick lj, rj;

  private Drivetrain drivetrain = new Drivetrain(1, 2);
  private Drive drive;

  @Override
  public void robotInit() {
    this.lj = new Joystick(0);
    this.rj = new Joystick(1);
    drive = new Drive(this.drivetrain, this.lj, this.rj);
  }

  @Override
  public void teleopInit() {
    drive.schedule();
    drive.initialize();
  }

  @Override
  public void teleopPeriodic() {
    drive.execute();
  }

  @Override
  public void autonomousInit() {
    drive.end(true);
  }
}
