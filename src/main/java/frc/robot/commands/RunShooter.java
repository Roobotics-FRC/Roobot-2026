package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.FloorSubsystem;

public class RunShooter extends Command{
    ShootSubsystem shootSubsystem;
    double shootRPS;
    FloorSubsystem floorSubsystem;
    double floorSpeed;

    public RunShooter(ShootSubsystem shootSubsystem, double shootRPS, FloorSubsystem floorSubsystem, double floorSpeed) {
        this.shootSubsystem = shootSubsystem;
        this.shootRPS = shootRPS;
        this.floorSubsystem = floorSubsystem;
        this.floorSpeed = floorSpeed;
        addRequirements(shootSubsystem);
        addRequirements(floorSubsystem);
    }

    @Override
    public void initialize() {
        shootSubsystem.SetShootSpeed(shootRPS);
        floorSubsystem.SetFloorSpeed(-floorSpeed);
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
        floorSubsystem.SetFloorSpeed(0);
    }
}
