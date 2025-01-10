package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Motor;

public class Slider {

    private DcMotor motor;

    public Slider(DcMotor motor){
        this.motor = motor;

    }
    public void setSpeed(double power){
        motor.setPower(power);
    }
}
