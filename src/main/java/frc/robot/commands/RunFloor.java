package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FloorSubsystem;

public class RunFloor extends Command{
    FloorSubsystem floorSubsystem;
    double speed;

    public RunFloor(FloorSubsystem floorSubsystem, double speed) {
        this.floorSubsystem = floorSubsystem;
        this.speed = speed;
        addRequirements(floorSubsystem);
    }

    @Override
    public void initialize() {
        floorSubsystem.SetFloorSpeed(-speed);
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
        floorSubsystem.SetFloorSpeed(0);
    }
}
