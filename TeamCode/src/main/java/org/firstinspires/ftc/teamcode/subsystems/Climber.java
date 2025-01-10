package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Climber {

    private DcMotor motor;

    public Climber(DcMotor motor){
        this.motor = motor;

    }
    public void setSpeed(double power){
        motor.setPower(power);
    }
}
