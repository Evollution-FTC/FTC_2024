package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Crochet;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@Autonomous(name = "Get Away Bleu", group = "")


public class AutonomeGetAwayBleu extends LinearOpMode {

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

        sleep(5000);
        drivetrain.setAllPositionSide(.75, -1, 1);
        drivetrain.setAllPosition(.75, 1, 1);







    }
}
