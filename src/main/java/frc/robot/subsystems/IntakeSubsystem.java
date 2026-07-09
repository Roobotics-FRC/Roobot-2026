package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final SparkMax shcoopMotor = new SparkMax(32, MotorType.kBrushless);
    private final SparkMax plopMotor = new SparkMax(33, MotorType.kBrushless);
    


    public void SetIntakeSpeed(double speed){
        shcoopMotor.setVoltage(-speed);
    }
    
    public void SetLiftingSpeed(double speed) { // need to code hard limits
        plopMotor.setVoltage(speed);
    }
}