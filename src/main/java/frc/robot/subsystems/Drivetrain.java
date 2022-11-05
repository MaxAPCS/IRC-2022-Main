package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private MotorController l, r;
    public Drivetrain(int lport, int rport) {
        this.l = new VictorSP(lport);
        this.r = new VictorSP(rport);
    }

    public void drive(double ls, double rs) {
        this.l.set(ls);
        this.r.set(rs);
    }

    public void stop() {
        this.l.stopMotor();
        this.r.stopMotor();
    }
}