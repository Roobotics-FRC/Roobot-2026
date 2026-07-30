package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;

public class ShootSubsystem extends SubsystemBase {
    private final TalonFX feederMotor = new TalonFX(21); 
    private final TalonFX shootMotor = new TalonFX(23);

    public NeutralModeValue brake = NeutralModeValue.Brake;
    
    public ShootSubsystem(){
        TalonFXConfiguration shootConfig = new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withNeutralMode(NeutralModeValue.Brake)
            );
        TalonFXConfiguration feederConfig = new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withNeutralMode(NeutralModeValue.Brake)
            );

        shootConfig.MotorOutput.withInverted(InvertedValue.Clockwise_Positive);
        feederConfig.MotorOutput.withInverted(InvertedValue.Clockwise_Positive);

        feederConfig.Slot0.kP = 0;
        feederConfig.Slot0.kI = 0;
        feederConfig.Slot0.kD = 0;
        feederConfig.Slot0.kS = 0.25;  //need to tune these 
        feederConfig.Slot0.kA = 0;
        feederConfig.Slot0.kV = 0.115;
        feederConfig.Feedback.SensorToMechanismRatio = 3.0;

        shootConfig.Slot0.kP = 0;
        shootConfig.Slot0.kI = 0;
        shootConfig.Slot0.kD = 0;
        shootConfig.Slot0.kS = 0.171; //need to tune these 
        shootConfig.Slot0.kA = 0;
        shootConfig.Slot0.kV = 0.116;
        shootConfig.Feedback.SensorToMechanismRatio = 3.0;
        

        feederMotor.getConfigurator().apply(feederConfig);
        shootMotor.getConfigurator().apply(shootConfig);
    }
    
    public void SetShootSpeed(double speed) {
        feederMotor.setControl(new VelocityVoltage(speed * 2)); //needs to follow shooter not just duplicate it (switch back to VelocityVoltage)
        shootMotor.setControl(new  VelocityVoltage(speed * 2));
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("vertical feeder RPS", feederMotor.getVelocity().getValueAsDouble());
        SmartDashboard.putNumber("shooter RPS", shootMotor.getVelocity().getValueAsDouble());
    }   
}