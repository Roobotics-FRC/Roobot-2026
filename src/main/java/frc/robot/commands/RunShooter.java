package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class RunShooter extends Command{
    ShootSubsystem shootSubsystem;
    double shootRPS;

    public RunShooter(ShootSubsystem shootSubsystem, double shootRPS) {
        this.shootSubsystem = shootSubsystem;
        this.shootRPS = shootRPS;
        addRequirements(shootSubsystem);
    }

    @Override
    public void initialize() {
        shootSubsystem.SetShootSpeed(shootRPS);
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
        shootSubsystem.SetShootSpeed(0);
    }
}
