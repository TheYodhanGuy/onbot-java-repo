package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class StopperServo extends LinearOpMode {
    
    private Servo stopperServo;


    // todo: write your code here
    @Override
    public void runOpMode() throws InterruptedException 
    {
         stopperServo = hardwareMap.servo.get("STOPPER_SERVO");
         telemetry.addLine("Stopper Servo init"+stopperServo.getPosition());
         telemetry.update();  
         waitForStart();
         
         
        
         while (opModeIsActive()) {
             if (gamepad1.x) {//left 0
              telemetry.addLine("Stopper servo"+stopperServo.getPosition());
              stopperServo.setPosition(0.0);
             } else if (gamepad1.y) {
                 telemetry.addLine("Stopper Servo"+stopperServo.getPosition());
                 stopperServo.setPosition(0.300);
             } else if (gamepad1.b) {
                telemetry.addLine("Magazine Servo"+stopperServo.getPosition());
                stopperServo.setPosition(1.0);
             }
             if (isStopRequested())
            {
                telemetry.addLine("Magazine Servo" + stopperServo.getPosition());
                telemetry.update();
                return;
            }
         }

         telemetry.update();

    }
         
}
