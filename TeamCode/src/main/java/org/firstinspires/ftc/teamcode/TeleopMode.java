package org.firstinspires.ftc.teamcode;  //Folder

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.Climber;
import org.firstinspires.ftc.teamcode.Gobeur;
import org.firstinspires.ftc.teamcode.Slider;
import org.firstinspires.ftc.teamcode.Box;
import org.firstinspires.ftc.teamcode.Drivetrain;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp(name = "Teleop")   //Mode

public class MecanumTeleOp extends LinearOpMode {  // Basic code here

   // private Gyroscope imu;

    private Climber cl;
    private Climber cr;
    private Gobeur gobeur;
    private Gobeur pivot; // point pivot de la pince
    private Slider slider;
    private Box box;
    private Drivetrain drivetrain;
    



    @Override
    public void runOpMode() {   //run while init

       drivetrain = new Drivetrain(
               hardwareMap.dcMotor.get("fl"),
                hardwareMap.dcMotor.get("fr"),
                hardwareMap.dcMotor.get("bl"),
               hardwareMap.dcMotor.get("br"));
        // imu = hardwareMap.get(Gyroscope.class, "imu");       // Defining which object is what on the robot
        cl = new Climber(hardwareMap.get(DcMotor.class, "cl"));
        cr = new Climber(hardwareMap.get(DcMotor.class, "cr"));
        gobeur = new Gobeur(hardwareMap.get(CRServo.class, "gobeur"));
        pivot = new Gobeur(hardwareMap.get(CRServo.class, "pivot"));
        slider = new Slider(hardwareMap.get(DcMotor.class, "slider"));
        box = new Box(hardwareMap.get(CRServo.class, "box"));
        





        telemetry.addData("Status", "Initialized");  // print in console
        telemetry.update();

        waitForStart();  // After run when start

        telemetry.addData("Status", "Running");   // print in console
        telemetry.update();

        if(opModeIsActive()) {

            while (opModeIsActive()) {

                double y = this.gamepad2.left_stick_y;
                double x = this.gamepad2.left_stick_x;//define the joystick variable
                double r = this.gamepad2.right_stick_x;
                double right_trigger = this.gamepad2.right_trigger;
                double left_trigger = this.gamepad2.left_trigger;
               
                double clPosition = 0;
                double crPosition = 0;
                double gobeurPosition = 0;
                double pivotPosition = 0;
                double sliderPosition = 0;
                double boxPosition = 0;
                
              if (gamepad1.dpad_up){
               sliderPosition = 1;  
              }
              
                if (gamepad1.dpad_down){
               sliderPosition = -1;  
              }

               if (gamepad1.dpad_right){
                  boxPosition = 1;
               }
               
               if (gamepad1.dpad_left){
                  boxPosition = -1;
               }
              
              if (gamepad1.b){
                  gobeurPosition = -1;
              }
              
              if (gamepad1.x){
                  gobeurPosition = 1;
              }
              
              if (gamepad1.y){
                  pivotPosition = -1;
              }
              
              if (gamepad1.a){
                  pivotPosition = 1;
              }

              if (gamepad1.right_bumper){
                 clPosition = 1;
                 crPosition = -1;
              }
               
              if (gamepad1.left_bumper){
                  clPosition = -1;
                  crPosition = 1;
              }


              slider.setSpeed(sliderPosition);
              gobeur.setSpeed(gobeurPosition);
              pivot.setSpeed(pivotPosition);
              cl.setSpeed(clPosition);
              cr.setSpeed(crPosition);
              drivetrain.mecanumDrive(x,y,r);
              box.setSpeed(boxPosition);
              
                //   telemetry.addData("Gyro", imu);
                telemetry.update();
            }
        }
    }
}
