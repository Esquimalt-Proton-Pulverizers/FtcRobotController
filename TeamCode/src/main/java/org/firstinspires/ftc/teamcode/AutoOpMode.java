package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.initialization.qual.Initialized;

@Autonomous

public class AutoOpMode extends LinearOpMode {

    private DcMotor frontLeft, frontRight, backLeft, backRight;
    @Override
    public void runOpMode() {


        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");


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
            //frontLeft.setPower(1)
            //frontRight.setPower(-1)
            //backLeft.setPower(1)
            //backRight.setPower(-1)
            //sleep(1000)
            frontLeft.setPower(-1);
            frontRight.setPower(-1);
            backLeft.setPower(-1);
            backRight.setPower(-1);
            sleep(2000);
            frontLeft.setPower(1);
            frontRight.setPower(-1);
            backLeft.setPower(1);
            backRight.setPower(-1);
            sleep(2000);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
            sleep(10000000);

            telemetry.addData("Status of OpMode: ", "Running");
        }

    }
}

