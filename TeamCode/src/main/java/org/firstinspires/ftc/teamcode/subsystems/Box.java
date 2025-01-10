package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;

public class Box {

    private CRServo servo;

    public Box(CRServo servo){
        this.servo = servo;

    }
    public void setSpeed(double power){
        servo.setPower(power);
    }
}
