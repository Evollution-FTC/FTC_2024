package org.firstinspires.ftc.teamcode;  //Folder

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Crochet;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Pince;
import org.firstinspires.ftc.teamcode.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.utils.CooldownBool;

@TeleOp(name = "Teleop_Test")   //Mode

public class TeleopMode extends LinearOpMode {  // Basic code here

   // private Gyroscope imu;

    private Crochet crochet;
    private Drivetrain drivetrain;
    private Pince pince;
    private Pivot pivot; // point pivot de la pince
    private CooldownBool cooldownA;
    private CooldownBool cooldownB;
    private Servo ServoCrochet1;


    @Override
    public void runOpMode() {   //run while init

        drivetrain = new Drivetrain(
                hardwareMap.dcMotor.get("frontLeft"),
                hardwareMap.dcMotor.get("frontRight"),
                hardwareMap.dcMotor.get("rearLeft"),
                hardwareMap.dcMotor.get("rearRight"));

       // imu = hardwareMap.get(Gyroscope.class, "imu");       // Defining which object is what on the robot
        pince = new Pince(hardwareMap.get(CRServo.class, "pince"));
        crochet = new Crochet(hardwareMap.get(Servo.class, "crochetRight"), hardwareMap.get(Servo.class, "crochetLeft"));
        cooldownA = new CooldownBool();
        cooldownB = new CooldownBool();

        pivot = new Pivot(hardwareMap.get(CRServo.class, "pivot"));





        telemetry.addData("Status", "Initialized");  // print in console
        telemetry.update();

        waitForStart();  // After run when start

        telemetry.addData("Status", "Running");   // print in console
        telemetry.update();

        if(opModeIsActive()) {

            while (opModeIsActive()) {

                double left_axisY = -this.gamepad1.left_stick_y;
                double left_axisX = -this.gamepad1.left_stick_x;//define the joystick variable
                double right_axisX = -this.gamepad1.right_stick_x;
                double right_trigger = this.gamepad2.right_trigger;
                double left_trigger = this.gamepad2.left_trigger;
                boolean a_button2 = cooldownA.test(this.gamepad2.a);
                boolean a_button1 = cooldownB.test(this.gamepad1.a);

                double left_axisY2 = this.gamepad2.left_stick_y;

                if (a_button1){
                    drivetrain.switchState();
                }

                drivetrain.mecanumDrive(-left_axisY, left_axisX, right_axisX);    //make the motor move


                pince.setSpeed(-left_trigger + right_trigger);
                pivot.setSpeed(left_axisY2);

                if (a_button2){
                    crochet.switchState();
                }


                telemetry.addData("Up", left_axisY);
                telemetry.addData("SlowMode", drivetrain.slowMode);
                telemetry.addData("Rotation", right_axisX);
                telemetry.addData("Side", left_axisX);// print in the console
                telemetry.addData("Speed pince", -left_trigger + right_trigger);
                telemetry.addData("Position Crochet", crochet.getAngleRight());
                telemetry.addData("Position Crochet", crochet.getAngleLeft());
                telemetry.addData("Encodeur AD", drivetrain.getFrontRightPosition());
                telemetry.addData("Encodeur AG", drivetrain.getFrontLeftPosition());
                telemetry.addData("Encodeur RD", drivetrain.getRearRightPosition());
                telemetry.addData("Encodeur RG", drivetrain.getRearLeftPosition());


                //   telemetry.addData("Gyro", imu);
                telemetry.update();
            }
        }
    }
}
