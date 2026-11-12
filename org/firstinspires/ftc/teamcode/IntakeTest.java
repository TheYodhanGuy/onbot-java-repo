package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Gyroscope;

public class IntakeTest extends LinearOpMode {
    Blinker control_Hub;
    Blinker expansion_Hub_2;
    DcMotor INTAKE_MTR;
    Gyroscope imu;
    ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() extends  {
        INTAKE_MTR = hardwareMap.dcMotor.get("INTAKE_MTR");

        waitForStart();

        while(opModeIsActive()) {
            wait(250);

            if(gamepad1.a) {
                INTAKE_MTR.setPower(-1);
            }
            else if (gamepad1.b) {
                INTAKE_MTR.setPower(1);
            }
            else if (gamepad1.x) {
                INTAKE_MTR.setPower(0);
            }
        }
    }
}
