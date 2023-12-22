package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveBaseSubSystem {
    private Motor frontLeft, frontRight, backRight, backLeft;
    private RevIMU imu;
    private HDrive hDrive;

    public DriveBaseSubSystem(HardwareMap hardwareMap) {
        frontLeft = new Motor(hardwareMap, "frontLeft");
        frontRight = new Motor(hardwareMap, "frontRight");
        backRight = new Motor(hardwareMap, "backRight");
        backLeft = new Motor(hardwareMap, "backLeft");

        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        frontLeft.encoder.setDirection(Motor.Direction.FORWARD);
        frontRight.encoder.setDirection(Motor.Direction.REVERSE);
        backRight.encoder.setDirection(Motor.Direction.REVERSE);
        backLeft.encoder.setDirection(Motor.Direction.FORWARD);

        imu = new RevIMU(hardwareMap);
        imu.init();
        hDrive = new HDrive(frontLeft, frontRight, backLeft, backRight);
    }

    public void drive(double forward, double strafe, double turn) {
        hDrive.driveRobotCentric(strafe, forward, turn);
    }

    public void stop() {
        drive(0, 0, 0);
    }

}
