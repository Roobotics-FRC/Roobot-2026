package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.FeedbackSensor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VoltageOut;

public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX intakeMotor = new TalonFX(21); 
    private final TalonFX shootMotor = new TalonFX(23);
    private final SparkMax shcoopMotor = new SparkMax(32, MotorType.kBrushless);
    private final SparkMax plopMotor = new SparkMax(33, MotorType.kBrushless);

    public IntakeSubsystem(){
        TalonFXConfiguration intakeConfig = new TalonFXConfiguration();

        intakeConfig.MotorOutput
            .withInverted(InvertedValue.Clockwise_Positive);
    
        intakeMotor.getConfigurator().apply(intakeConfig);
        shootMotor.getConfigurator().apply(intakeConfig);
    }
    
    public void SetIntakeSpeed(double speed) {
        intakeMotor.setControl(new VoltageOut(speed));
        shootMotor.setControl(new VoltageOut(speed));
        shcoopMotor.setVoltage(-speed);
    }

    public void SetLiftingSpeed(double speed) { // need to code hard limits
        plopMotor.setVoltage(12);
    }

}