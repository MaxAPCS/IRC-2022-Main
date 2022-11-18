// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Drive;

public class Robot extends TimedRobot {
  private Joystick lj, rj;

  private Drivetrain drivetrain = new Drivetrain(1, 2);
  private Drive drive;
  private Command autoCommand = new SequentialCommandGroup(
    new AutoDrive(drivetrain, 4, 4).withTimeout(2),
    new AutoDrive(drivetrain, 0, 3).withTimeout(1)
  );

  @Override
  public void robotInit() {
    this.lj = new Joystick(0);
    this.rj = new Joystick(1);
    this.drive = new Drive(this.drivetrain, this.lj, this.rj);
  }

  @Override
  public void teleopInit() {
    this.autoCommand.end(false);
    this.drive.schedule();
    this.drive.initialize();
  }

  @Override
  public void teleopPeriodic() {
    this.drive.execute();
  }

  @Override
  public void autonomousInit() {
    this.drive.end(true);
    this.autoCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    this.autoCommand.execute();
  }
}
