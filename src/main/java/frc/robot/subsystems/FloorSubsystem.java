package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FloorSubsystem extends SubsystemBase {

    private final SparkMax floorMotor = new SparkMax(Constants.floorMotorID, MotorType.kBrushless);

    public void SetFloorSpeed(double speed){
        floorMotor.setVoltage(speed); 
    }
}
