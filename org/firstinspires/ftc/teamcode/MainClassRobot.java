package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class MainClassRobot extends LinearOpMode {

    ElapsedTime time = new ElapsedTime();

    void main() {
            telemetry.addLine("Hello World!");
            telemetry.addLine("Time running is" + time);
    }

    void gamepad() {
        if(gamepad1.a) {
            telemetry.addLine("A button is pressed.");
        }
        else {
            telemetry.addLine("A button isn't pressed.");
        }
    }
    
    @Override
    void runOpMode() {
        waitForStart();
        
        while(opModeIsActive()) {
            main();
            gamepad();
        }
    }
}
