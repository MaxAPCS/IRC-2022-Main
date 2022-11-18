package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase; 

public class AutoDrive extends CommandBase {
    private Drivetrain drivetrain;
    private double ls, rs;

    public AutoDrive(Drivetrain dt, double ls, double rs) {
        this.drivetrain = dt;
        this.ls = ls;
        this.rs = rs;
        super.addRequirements(drivetrain);
    }
    
    @Override
    public void initialize() {
        drivetrain.stop();
    }

    @Override
    public void execute() {
        drivetrain.drive(ls, rs);
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
