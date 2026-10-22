package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.controls.VoltageOut;
import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
    private final TalonFX t_turnMotor = new TalonFX(Constants.t_turnMotorID); 

    public TurretSubsystem(){
    }
    
    public void TurretTurn(double speed) { // need to code hard limits (TURRET TURN)
        t_turnMotor.setControl(new VoltageOut(speed));
    }
}


// we dont turn the turret so this is unused