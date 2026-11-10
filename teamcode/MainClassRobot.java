package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp

public class MainClassRobot extends LinearOpMode {
    private Blinker control_Hub;
    private Blinker expansion_Hub_2;
    private DcMotor fL_MTR;
    private DcMotor fR_MTR;
    private DcMotor rL_MTR;
    private DcMotor rR_MTR;
    private DcMotor INTAKE_MTR, GUIDE_MTR, LAUNCH_MTR;
    private Gyroscope imu;
    private int viperPosition = 0;
    private ElapsedTime runtime = new ElapsedTime();
    private CRServo LAUNCH_SERVO;
    private Servo pushServo, nudgeServo;

    @Override
    public void runOpMode() throws InterruptedException {

        // todo: write your code here

        fL_MTR = hardwareMap.dcMotor.get("FL_MTR");
        rL_MTR = hardwareMap.dcMotor.get("RL_MTR");
        fR_MTR = hardwareMap.dcMotor.get("FR_MTR");
        rR_MTR = hardwareMap.dcMotor.get("RR_MTR");

        INTAKE_MTR = hardwareMap.dcMotor.get("INTAKE_MTR");
        GUIDE_MTR = hardwareMap.dcMotor.get("GUIDE_MTR");
        LAUNCH_SERVO = hardwareMap.crservo.get("LAUNCH_SERVO");
        LAUNCH_MTR = hardwareMap.dcMotor.get("LAUNCH_MTR");
        pushServo = hardwareMap.servo.get("PUSH_SERVO");
        nudgeServo = hardwareMap.servo.get("NUDGE_SERVO");

        // arm_MTR = hardwareMap.dcMotor.get("ARM_MOTOR");
        // arm_MTR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // arm_MTR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // fR_MTR.setDirection(DcMotorSimple.Direction.REVERSE);
        // rR_MTR.setDirection(DcMotorSimple.Direction.REVERSE);
        pushServo.setPosition(1.0);

        waitForStart();

        if (isStopRequested()) {
            fL_MTR.setPower(0);
            rL_MTR.setPower(0);
            fR_MTR.setPower(0);
            rR_MTR.setPower(0);
            pushServo.setPosition(1.0);
            return;

        }

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            fL_MTR.setPower(frontLeftPower);
            rL_MTR.setPower(backLeftPower);
            fR_MTR.setPower(frontRightPower);
            rR_MTR.setPower(backRightPower);

            if (gamepad1.a) { // Launcher
                // INTAKE_MTR.setDirection(DcMotorSimple.Direction.REVERSE);
                INTAKE_MTR.setPower(1);
                LAUNCH_SERVO.setDirection(DcMotorSimple.Direction.REVERSE);
                LAUNCH_SERVO.setPower(1.0);

                GUIDE_MTR.setPower(0.5);

            } else if (gamepad1.b) {
                INTAKE_MTR.setPower(0);
                GUIDE_MTR.setPower(0);
                LAUNCH_SERVO.setPower(0.0);

            }

            if (gamepad1.x) {// left 0
                sleep(1000);
                telemetry.addLine("Magazine servo" + pushServo.getPosition());
                LAUNCH_SERVO.setDirection(DcMotorSimple.Direction.FORWARD);
                LAUNCH_SERVO.setPower(1.0);
                // GUIDE_MTR.setPower(1.0);

                pushServo.setPosition(0.25);
                sleep(1200);
                pushServo.setPosition(1.0);

            } else if (gamepad1.y) {
                telemetry.addLine("Magazine Servo" + pushServo.getPosition());

                pushServo.setPosition(1.0);
            }

            if (gamepad1.dpad_up) {
                LAUNCH_MTR.setDirection(DcMotorSimple.Direction.REVERSE);
                LAUNCH_MTR.setPower(1.0);
                // sleep(1300);

            } else if (gamepad1.dpad_down) {
                LAUNCH_SERVO.setPower(0.0);
                LAUNCH_MTR.setPower(0.0);
                GUIDE_MTR.setPower(0.0);
                INTAKE_MTR.setPower(0.0);

            } else if (gamepad1.dpad_right) {
                // LAUNCH_SERVO.setPower(1.0);
                GUIDE_MTR.setPower(1.0);
            }

        }
    }

}
