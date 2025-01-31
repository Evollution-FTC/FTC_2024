package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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

import org.firstinspires.ftc.teamcode.Drivetrain;

@Autonomous(name = "Autonome", group = "")


public class AutonomousTest extends LinearOpMode {

    private Drivetrain drivetrain;
    private Gobeur gobeur;
    private Gobeur pivot; // point pivot de la pince
    private Slider slider;
    private Box box;
    
    @Override
    public void runOpMode(){


     
        drivetrain = new Drivetrain(
                hardwareMap.dcMotor.get("fl"),
                hardwareMap.dcMotor.get("fr"),
                hardwareMap.dcMotor.get("bl"),
                hardwareMap.dcMotor.get("br"));
       
        gobeur = new Gobeur(hardwareMap.get(CRServo.class, "gobeur"));
        pivot = new Gobeur(hardwareMap.get(CRServo.class, "pivot"));
        slider = new Slider(hardwareMap.get(DcMotor.class, "slider"));
        box = new Box(hardwareMap.get(CRServo.class, "box"));
        DigitalChannel in2 = hardwareMap.digitalChannel.get("LimitIn2");
        DigitalChannel out = hardwareMap.digitalChannel.get("LimitOut");
        DigitalChannel in = hardwareMap.digitalChannel.get("LimitIn");



                telemetry.addData("FrontRightPosition", drivetrain.getFrontRightPosition());
                telemetry.addData("FrontLeftPosition", drivetrain.getFrontLeftPosition());
                telemetry.addData("RearRightPosition", drivetrain.getRearRightPosition());
                telemetry.addData("RearLeftPosition", drivetrain.getRearLeftPosition());
      

        waitForStart();

        pivot.setSpeed(1);
        sleep(150);
                slider.setAllPosition(1 , 7);

        drivetrain.setAllPosition(.25, -2, -2);
        sleep(150);
        box.setSpeed(-0.75);
        sleep(150);
                        slider.setAllPosition(1 , -7);
        pivot.setSpeed(-5);

    




     
        
         
     




    }
}
