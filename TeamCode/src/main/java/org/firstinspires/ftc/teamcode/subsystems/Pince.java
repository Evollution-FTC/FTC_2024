package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;

public class Pince {

    private CRServo pince;

    public Pince(CRServo pince){
        this.pince = pince;

    }
    public void setSpeed(double power){
        pince.setPower(power);
    }
}
