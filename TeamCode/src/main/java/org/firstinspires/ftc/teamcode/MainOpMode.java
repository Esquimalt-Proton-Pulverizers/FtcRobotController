package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MainOpMode extends LinearOpMode {

    private DcMotor armLifter;

    DriveBaseSubSystem driveBase;

    @Override
    public void runOpMode() {

        armLifter = hardwareMap.get(DcMotorEx.class, "armLifter");

        driveBase = new DriveBaseSubSystem(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double forward;
        double strafe;
        double rotation;
        double lift;
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


            telemetry.addData("Front", forward);
            telemetry.addData("Strafe", strafe);
            telemetry.addData("Rotation", rotation);

            driveBase.drive(forward, strafe, rotation);

            if (lift <= upperStop || lift >=  downStop)
            {
                armLifter.setPower(lift/64);
            }

            telemetry.update();

        }
    }
}