package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TurretSubsystem;

public class SpinTurret extends Command{
    TurretSubsystem turretSubsystem;
    double speed;

    public SpinTurret(TurretSubsystem turretSubsystem, double speed) {
        this.turretSubsystem = turretSubsystem;
        this.speed = speed;
        addRequirements(turretSubsystem);
    }

    @Override
    public void initialize() {
        turretSubsystem.TurretTurn(speed);
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        turretSubsystem.TurretTurn(0);
    }
}
