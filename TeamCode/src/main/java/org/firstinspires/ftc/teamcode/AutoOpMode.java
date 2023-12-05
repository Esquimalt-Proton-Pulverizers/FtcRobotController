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

    DriveBaseSubSystem driveBase;
    double autoPower = 0.6;

    @Override
    public void runOpMode() {

        driveBase = new DriveBaseSubSystem(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        driveBase.drive(autoPower, 0, 0);
        sleep(1000);
        driveBase.drive(-autoPower, 0, 0);
        sleep(1000);
        driveBase.drive(0, 0, autoPower);
        sleep(1000);
        driveBase.stop();


            //TODO: Make robot drive
            //frontLeft.setPower(1)
            //frontRight.setPower(-1)
            //backLeft.setPower(1)
            //backRight.setPower(-1)
            //sleep(1000)
//            frontLeft.setPower(-1);
//            frontRight.setPower(-1);
//            backLeft.setPower(-1);
//            backRight.setPower(-1);
//            sleep(2000);
//            frontLeft.setPower(1);
//            frontRight.setPower(-1);
//            backLeft.setPower(1);
//            backRight.setPower(-1);
//            sleep(2000);
//            frontLeft.setPower(0);
//            frontRight.setPower(0);
//            backLeft.setPower(0);
//            backRight.setPower(0);
//            sleep(10000000);


    }
}

