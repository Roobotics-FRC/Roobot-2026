package frc.robot;

public class Constants {
    
    // motor IDs

    public static int feederMotorID = 21;
    public static int t_turnMotorID = 22;
    public static int shootMotorID = 23;
    public static int scoopMotorID = 32;
    public static int floorMotorID = 35;

    //motor tuneage -------------

    // feeder motor (into shooter!)
    public static double feeder_kP = 0;
    public static double feeder_kI = 0;
    public static double feeder_kD = 0;
    public static double feeder_kS = 0.25;
    public static double feeder_kA = 0;
    public static double feeder_kV = 0.115;
    public static double feeder_STMratio = 3.0;

    // shoot motor (turret shooter!)
    public static double shoot_kP = 0;
    public static double shoot_kI = 0;
    public static double shoot_kD = 0;
    public static double shoot_kS = 0.171;
    public static double shoot_kA = 0;
    public static double shoot_kV = 0.116;
    public static double shoot_STMratio = 3.0;




}
