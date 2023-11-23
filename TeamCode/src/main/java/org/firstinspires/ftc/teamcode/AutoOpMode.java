package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto OpMode")
public class AutoOpMode extends LinearOpMode {

    private DcMotor testMotorLeft, testMotorRight, testMotorForward, testMotorBackward;

    @Override
    public void runOpMode() throws InterruptedException {
        testMotorBackward = hardwareMap.get(DcMotor.class, "testMotorLeft");
        testMotorForward = hardwareMap.get(DcMotor.class, "testMotorRight");
        testMotorLeft = hardwareMap.get(DcMotor.class, "testMotorForward");
        testMotorRight = hardwareMap.get(DcMotor.class, "testMotorBackward");
        testMotorLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        testMotorBackward.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

//        testMotorBackward.setPower(1);
//        testMotorForward.setPower(1);
        testMotorLeft.setPower(-1);
        testMotorRight.setPower(-1);
        ElapsedTime timer = new ElapsedTime();
        while (timer.milliseconds() <= 750) {}
        testMotorBackward.setPower(1);
        testMotorForward.setPower(1);
        testMotorLeft.setPower(0);
        testMotorRight.setPower(0);
        timer = new ElapsedTime();
        while (timer.milliseconds() <= 1000) {}
        testMotorBackward.setPower(0);
        testMotorForward.setPower(0);


    }
}
