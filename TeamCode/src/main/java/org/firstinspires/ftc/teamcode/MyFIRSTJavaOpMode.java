package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;

@TeleOp

public class MyFIRSTJavaOpMode extends LinearOpMode {

    private Gyroscope imu;
    private DcMotor frontLeft, frontRight, backRight, backLeft, armLifter;

    @Override
    public void runOpMode() {

        imu = hardwareMap.get(Gyroscope.class, "imu");

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        armLifter = hardwareMap.get(DcMotorEx.class, "armLifter");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double forward = 0;
        double strafe = 0;
        double rotation = 0;
        double lift = 0;
        double upperStop = 10;
        double downStop = -10;

        while (opModeIsActive()) {
            //TODO: Make robot drive
            forward = -gamepad1.left_stick_y;
            strafe = gamepad1.left_stick_x;
            rotation = gamepad1.right_stick_x;
            lift = gamepad1.right_trigger - gamepad1.left_trigger;
            telemetry.addData("Status of OpMode: ", "Running");

//            testMotor.setPower(forward);
//            telemetry.addData("Target Power: ", forward);
//            telemetry.addData("Motor Power: ", testMotor.getPower());
            telemetry.addData("Left Stick", gamepad1.left_stick_x);

//            leftMotor.setPower(forward - rotation);
//            rightMotor.setPower(forward + rotation);
//            forwardMotor.setPower(strafe + rotation);
//            backMotor.setPower(strafe - rotation);

            telemetry.addData("Front", forward);
            telemetry.addData("Strafe", strafe);
            telemetry.addData("Rotation", rotation);

            frontLeft.setPower(forward + strafe + rotation);
            frontRight.setPower(forward - strafe - rotation);
            backRight.setPower(forward + strafe - rotation);
            backLeft.setPower(forward - strafe + rotation);

            if (lift < upperStop || lift >  downStop)
            {
                armLifter.setPower(lift);
            }

            telemetry.update();

        }
    }
}