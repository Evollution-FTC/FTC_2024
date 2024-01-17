package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;

public class Pivot {

    private CRServo pivot;

    public Pivot(CRServo pivot){
        this.pivot = pivot;

    }

    double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    public void setSpeed(double power)
    {
        double powerMap = map(power, -1, 1, -.40, .40);
        pivot.setPower(-powerMap);
    }
}
