package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Crochet;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@Autonomous(name = "Autonome Bleu", group = "")


public class Autonome extends LinearOpMode {

    private Drivetrain drivetrain;
    private Crochet crochet;

    @Override
    public void runOpMode(){


        crochet = new Crochet(hardwareMap.get(Servo.class, "crochetRight"), hardwareMap.get(Servo.class, "crochetLeft"));

        drivetrain = new Drivetrain(
                hardwareMap.dcMotor.get("frontLeft"),
                hardwareMap.dcMotor.get("frontRight"),
                hardwareMap.dcMotor.get("rearLeft"),
                hardwareMap.dcMotor.get("rearRight"));



        telemetry.addData("FrontRightPosition", drivetrain.getFrontRightPosition());
        telemetry.addData("FrontLeftPosition", drivetrain.getFrontLeftPosition());
        telemetry.addData("RearRightPosition", drivetrain.getRearRightPosition());
        telemetry.addData("RearLeftPosition", drivetrain.getRearLeftPosition());


        waitForStart();


        drivetrain.setAllPositionSide(.5, 1, -1);
        drivetrain.setAllPosition(.25, 4, 4);
        crochet.switchState();
        sleep(250);
        drivetrain.setAllPosition(.75, -6, -6);
        crochet.switchState();
        drivetrain.setAllPositionSide(.75, -2, 2);
        drivetrain.setAllPosition(.75, 5, 5);
        drivetrain.setAllPositionSide(.75, 2, -2);
        drivetrain.setAllPosition(.75, -4, -4);
        drivetrain.setAllPositionSide(1, -3, 3);






    }
}
