package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class FIveTurnServoTest extends LinearOpMode {
    
    private Servo cylinderServo;
    


    // todo: write your code here
    @Override
    public void runOpMode() throws InterruptedException 
    {
        cylinderServo = hardwareMap.servo.get("MAG_SERVO");
         telemetry.addLine("Magazine Servo init"+cylinderServo.getPosition());
         telemetry.update(); 
         cylinderServo.setPosition(0.0);
         
         waitForStart();
         
           
        while (opModeIsActive()) {
            // Example: Control with gamepad joysticks
            // Map joystick input (-1 to 1) to servo position (0 to 1)
            // The 0-1 range represents the full 5 turns of the goBILDA servo.
            //double servoPosition = (gamepad1.left_stick_y + 1) / 2.0; // Adjust as needed for desired control

            // Ensure the position stays within the 0-1 range
            //servoPosition = Math.max(0.0, Math.min(1.0, servoPosition
            
            
            if (gamepad1.x) {
                cylinderServo.setPosition(0.05);
            } 
            else if (gamepad1.y){
                cylinderServo.setPosition(0.105);//0
            }else if (gamepad1.b){
                cylinderServo.setPosition(0.16);//0
            }else if (gamepad1.a){
                cylinderServo.setPosition(0.22);//0
            }
            if (gamepad1.back) {
                cylinderServo.setPosition(0.0); 
            }

            telemetry.addData("Servo Position", cylinderServo.getPosition());
            telemetry.update();
            if (isStopRequested())
        {
             cylinderServo.setPosition(0.0);
         
            telemetry.addLine("Magazine Servo" + cylinderServo.getPosition());
            telemetry.update();
            return;
         }
        }
    }
}