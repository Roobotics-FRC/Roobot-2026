package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final SparkMax scoopMotor = new SparkMax(Constants.scoopMotorID, MotorType.kBrushless);

    public void SetIntakeSpeed(double speed){
        scoopMotor.setVoltage(-speed); // do not want set voltage change to velocity voltage
    }
}