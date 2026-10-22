package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VelocityVoltage;
import frc.robot.Constants;

public class ShootSubsystem extends SubsystemBase {
    private final TalonFX feederMotor = new TalonFX(Constants.feederMotorID); 
    private final TalonFX shootMotor = new TalonFX(Constants.shootMotorID);
    
    public ShootSubsystem() {
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

        feederConfig.Slot0.kP = Constants.feeder_kP;
        feederConfig.Slot0.kI = Constants.feeder_kI;
        feederConfig.Slot0.kD = Constants.feeder_kD;
        feederConfig.Slot0.kS = Constants.feeder_kS;  
        feederConfig.Slot0.kA = Constants.feeder_kA;
        feederConfig.Slot0.kV = Constants.feeder_kV;
        feederConfig.Feedback.SensorToMechanismRatio = Constants.feeder_STMratio;

        shootConfig.Slot0.kP = Constants.shoot_kP;
        shootConfig.Slot0.kI = Constants.shoot_kI;
        shootConfig.Slot0.kD = Constants.shoot_kD;
        shootConfig.Slot0.kS = Constants.shoot_kS;
        shootConfig.Slot0.kA = Constants.shoot_kA;
        shootConfig.Slot0.kV = Constants.shoot_kV;
        shootConfig.Feedback.SensorToMechanismRatio = Constants.shoot_STMratio;
        

        feederMotor.getConfigurator().apply(feederConfig);
        shootMotor.getConfigurator().apply(shootConfig);
    }
    
    public void SetShootSpeed(double speed) {
        feederMotor.setControl(new VelocityVoltage(speed * 2)); //needs to follow shooter not just duplicate it (switch back to VelocityVoltage)
        shootMotor.setControl(new  VelocityVoltage(speed * 2)); // wait why am i multiplying it by two
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("vertical feeder RPS", feederMotor.getVelocity().getValueAsDouble());
        SmartDashboard.putNumber("shooter RPS", shootMotor.getVelocity().getValueAsDouble());
    }   
}