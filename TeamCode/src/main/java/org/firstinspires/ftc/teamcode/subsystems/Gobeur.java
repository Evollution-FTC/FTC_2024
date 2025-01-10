package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;

public class Gobeur {

    private CRServo servo;

    public Gobeur(CRServo servo){
        this.servo = servo;

    }
    public void setSpeed(double power){
        servo.setPower(power);
    }
}
