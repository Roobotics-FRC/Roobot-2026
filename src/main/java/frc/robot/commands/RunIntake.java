package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.FloorSubsystem;

public class RunIntake extends Command{
    IntakeSubsystem intakeSubsystem;
    FloorSubsystem floorSubsystem;
    double intakeSpeed;
    double floorSpeed;

    public RunIntake(IntakeSubsystem intakeSubsystem, double intakeSpeed, FloorSubsystem floorSubsystem, double floorSpeed) {
        this.intakeSubsystem = intakeSubsystem;
        this.floorSubsystem = floorSubsystem;
        this.intakeSpeed = intakeSpeed;
        this.floorSpeed = floorSpeed;

        addRequirements(intakeSubsystem);
        addRequirements(floorSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.SetIntakeSpeed(intakeSpeed);
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
        intakeSubsystem.SetIntakeSpeed(0);
        floorSubsystem.SetFloorSpeed(0);
    }
}
