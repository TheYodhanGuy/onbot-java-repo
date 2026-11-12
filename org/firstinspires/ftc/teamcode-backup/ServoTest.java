package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class ServoTest extends LinearOpMode {
    
    private Servo cylinderServo,nudgeServo;


    // todo: write your code here
    @Override
    public void runOpMode() throws InterruptedException 
    {
         cylinderServo = hardwareMap.servo.get("PUSH_SERVO");
         nudgeServo = hardwareMap.servo.get("NUDGE_SERVO");
         
         telemetry.addLine("Push Servo init"+cylinderServo.getPosition());
         telemetry.addLine("nudge Servo init"+nudgeServo.getPosition());
         
         cylinderServo.setPosition(1.0);
          telemetry.update(); 
         waitForStart();
         
         
        
         while (opModeIsActive()) {
             if (gamepad1.x) {//left 0
              telemetry.addLine("Magazine servo"+cylinderServo.getPosition());
         
               cylinderServo.setPosition(0.25);
               sleep(1200);
               cylinderServo.setPosition(1.0);
                
             } else if (gamepad1.y) {
              telemetry.addLine("Magazine Servo"+cylinderServo.getPosition());
         
                 cylinderServo.setPosition(1.0);
             } else if (gamepad1.a) {
                  nudgeServo.setPosition(0.7);
              
             } else if (gamepad1.b) {
                  nudgeServo.setPosition(1.0);
              
             }
             if (isStopRequested())
        {
            telemetry.addLine("Magazine Servo" + cylinderServo.getPosition());
            telemetry.update();
            return;
         }
         }

         telemetry.update();

    }
         
}
