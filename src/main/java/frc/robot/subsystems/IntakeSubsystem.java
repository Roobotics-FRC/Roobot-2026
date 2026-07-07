package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VoltageOut;

// this command shoots by running the intake motor and turret 
public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX intakeMotor = new TalonFX(21); 
    private final TalonFX shootMotor = new TalonFX(23);

    public IntakeSubsystem(){
        TalonFXConfiguration intakeConfig = new TalonFXConfiguration();

        intakeConfig.MotorOutput
            .withInverted(InvertedValue.Clockwise_Positive);
        
        intakeMotor.getConfigurator().apply(intakeConfig);
        shootMotor.getConfigurator().apply(intakeConfig);
    }
    
    public void setIntakeSpeed(double speed) {
        intakeMotor.setControl(new VoltageOut(speed));
        shootMotor.setControl(new VoltageOut(speed));
    }
}
