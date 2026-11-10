package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class ContServoTest extends LinearOpMode {
    
    private CRServo pickupServo;


    // todo: write your code here
    @Override
    public void runOpMode() throws InterruptedException 
    {
        //pickupServo = hardwareMap.crservo.get("ARM_PICKUP");
        pickupServo = hardwareMap.crservo.get("LAUNCH_SERVO");
         telemetry.addLine("pickupServo init"+pickupServo.getClass());
         telemetry.update();  
         waitForStart();
         
          if (isStopRequested())
        {
            telemetry.addLine("pickupServo");
            telemetry.update();
            return;
            
        }
        
         while (opModeIsActive()) {
             if (gamepad1.dpad_up) {
              telemetry.addLine("pickupServo dpad up"+pickupServo.getClass());
              // pickupServo.setDirection(DcMotorSimple.Direction.REVERSE);
              
               pickupServo.setPower(1.0);
                
             } else if (gamepad1.dpad_down) {
              telemetry.addLine("pickupServo dpad down"+pickupServo.getClass());
         
                 pickupServo.setPower(0.0);
             }
             
             
             
            
         }

         telemetry.update();

    }
}
