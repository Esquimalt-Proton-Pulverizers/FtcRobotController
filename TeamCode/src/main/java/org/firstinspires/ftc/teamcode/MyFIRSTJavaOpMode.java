package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.initialization.qual.Initialized;

@TeleOp

public class MyFIRSTJavaOpMode extends LinearOpMode {

    private Gyroscope imu;
    private DcMotor testMotorLeft, testMotorRight, testMotorForward, testMotorBackward;

    @Override
    public void runOpMode() {

        imu = hardwareMap.get(Gyroscope.class, "imu");
        testMotorLeft = hardwareMap.get(DcMotor.class, "testMotorLeft");
        testMotorRight = hardwareMap.get(DcMotor.class, "testMotorRight");
        testMotorForward = hardwareMap.get(DcMotor.class, "testMotorForward");
        testMotorBackward = hardwareMap.get(DcMotor.class, "testMotorBackward");
        testMotorLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        testMotorBackward.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double targetPowerForward = 0;
        double targetPowerSide = 0;
        double targetPowerRotation = 0;

        while (opModeIsActive()) {
            //TODO: Make robot drive
            targetPowerForward = gamepad1.left_stick_y;
            targetPowerSide = gamepad1.left_stick_x;
            targetPowerRotation = gamepad1.right_stick_x;
            telemetry.addData("Status of OpMode: ", "Running");

//            testMotor.setPower(targetPowerForward);
//            telemetry.addData("Target Power: ", targetPowerForward);
//            telemetry.addData("Motor Power: ", testMotor.getPower());
            telemetry.addData("Left Stick", gamepad1.left_stick_x);

            testMotorLeft.setPower(targetPowerForward - targetPowerRotation);
            testMotorRight.setPower(targetPowerForward + targetPowerRotation);
            testMotorForward.setPower(targetPowerSide + targetPowerRotation);
            testMotorBackward.setPower(targetPowerSide - targetPowerRotation);

//            if (targetPowerRotation != 0 && targetPowerRotation > 0.1d)
//            {
//                testMotorLeft.setPower(targetPowerRotation);
//                testMotorForward.setPower(targetPowerRotation);
//
//                testMotorRight.setDirection(DcMotorSimple.Direction.REVERSE);
//                testMotorBackward.setDirection(DcMotorSimple.Direction.REVERSE);
//
//                testMotorRight.setPower(targetPowerRotation/2);
//                testMotorBackward.setPower(targetPowerRotation/2);
//            }
//
//            else if (targetPowerRotation != 0 && targetPowerRotation < 0.1d)
//            {
//                testMotorLeft.setPower(targetPowerRotation/2);
//                testMotorForward.setPower(targetPowerRotation/2);
//
//                testMotorRight.setDirection(DcMotorSimple.Direction.REVERSE);
//                testMotorBackward.setDirection(DcMotorSimple.Direction.REVERSE);
//
//                testMotorRight.setPower(targetPowerRotation);
//                testMotorBackward.setPower(targetPowerRotation);
//            }

            telemetry.update();

        }


    }
}