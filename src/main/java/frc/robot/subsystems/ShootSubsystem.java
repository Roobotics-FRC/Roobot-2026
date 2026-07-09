package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VoltageOut;

public class ShootSubsystem extends SubsystemBase {
    private final TalonFX intakeMotor = new TalonFX(21); 
    private final TalonFX shootMotor = new TalonFX(23);

    public NeutralModeValue brake = NeutralModeValue.Brake;
    
    public ShootSubsystem(){
        TalonFXConfiguration shootConfig = new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withNeutralMode(NeutralModeValue.Brake)
            );

        shootConfig.MotorOutput.withInverted(InvertedValue.Clockwise_Positive);

        intakeMotor.getConfigurator().apply(shootConfig);
        shootMotor.getConfigurator().apply(shootConfig);
    }
    
    public void SetShootSpeed(double speed) {
        intakeMotor.setControl(new VoltageOut(speed));
        shootMotor.setControl(new VoltageOut(speed));
    }
}