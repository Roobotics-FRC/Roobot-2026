package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.controls.VoltageOut;

public class TurretSubsystem extends SubsystemBase {
    private final TalonFX t_turnMotor = new TalonFX(22); 

    public TurretSubsystem(){
    }
    
    public void TurretTurn(double speed) { // need to code hard limits
        t_turnMotor.setControl(new VoltageOut(speed));
    }
}