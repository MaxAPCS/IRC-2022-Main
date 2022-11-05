package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase; 

public class Drive extends CommandBase {
    private Drivetrain drivetrain;
    private Joystick lj, rj;

    public Drive(Drivetrain dt, Joystick leftJ, Joystick rightJ) {
        this.drivetrain = dt;
        this.lj = leftJ;
        this.rj = rightJ;
        super.addRequirements(drivetrain);
    }
    
    @Override
    public void initialize() {
        drivetrain.stop();
    }

    @Override
    public void execute() {
        drivetrain.drive(lj.getY(), rj.getY());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean stop) {
        drivetrain.stop();
    }
}
