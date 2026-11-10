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

@TeleOp

public class LauncherTest extends LinearOpMode {
    private Blinker control_Hub;
    private Blinker expansion_Hub_2;
    private DcMotor LL_MTR;
    private DcMotor LR_MTR;
    private Gyroscope imu;
    private int viperPosition = 0;
    private CRServo pickupServo;
    private Servo stopperServo;

    
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException 
    {
  
         LL_MTR = hardwareMap.dcMotor.get("LL_MTR");
         LR_MTR = hardwareMap.dcMotor.get("LR_MTR");
         pickupServo = hardwareMap.crservo.get("LAUNCH_SERVO");
         //stopperServo = hardwareMap.servo.get("STOPPER_SERVO");
         //telemetry.addLine("Stopper Servo init"+stopperServo.getPosition());
        //stopperServo.setPosition(0.0);
         
        LR_MTR.setDirection(DcMotorSimple.Direction.FORWARD);
        LL_MTR.setDirection(DcMotorSimple.Direction.REVERSE);
        //LL_MTR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        //LR_MTR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       
        waitForStart();

        if (isStopRequested())
        {
            LL_MTR.setPower(0);
            LR_MTR.setPower(0);
            
                 pickupServo.setPower(0.0);
            return;
        }

        while (opModeIsActive()) {
            
            
             if (gamepad1.dpad_up) {
              telemetry.addLine("pickupServo dpad up"+pickupServo.getClass());
               //pickupServo.setDirection(DcMotorSimple.Direction.REVERSE);
              
               pickupServo.setPower(1.0);
                
             } else if (gamepad1.dpad_down) {
              telemetry.addLine("pickupServo dpad down"+pickupServo.getClass());
         
                 pickupServo.setPower(0.0);
             }
            
            
            if (gamepad1.a) { // Launcher
                LL_MTR.setPower(0.750);
                LR_MTR.setPower(0.750);
                
            } else if (gamepad1.b) {
                LL_MTR.setPower(0);
                LR_MTR.setPower(0);
                
            }
             if (gamepad1.x) {//left 0
              //telemetry.addLine("Stopper servo"+stopperServo.getPosition());
              //stopperServo.setPosition(0.0);
              telemetry.addLine("pickupServo dpad down"+pickupServo.getClass());
         
                 pickupServo.setPower(0.0);
             } else if (gamepad1.y) {
                 telemetry.addLine("pickupServo dpad up"+pickupServo.getClass());
               //pickupServo.setDirection(DcMotorSimple.Direction.REVERSE);
              
               pickupServo.setPower(1.0);
              
                 //telemetry.addLine("Stopper Servo"+stopperServo.getPosition());
                // stopperServo.setPosition(0.150);
             }
            
        }
    }
    
}
    
