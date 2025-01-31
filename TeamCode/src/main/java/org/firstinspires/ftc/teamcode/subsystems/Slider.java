package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Slider {
        private DcMotor motor;
        private  boolean _state;

      
    public Slider(DcMotor motor){
        this.motor = motor;
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotorSimple.Direction.FORWARD);   // setting the motor direction


    }
 
    public void setSpeed(double m , double m2) {
        motor.setPower(m  - m2);
        

    }
  
       public int getMototPosition(){
       return motor.getCurrentPosition();
    }
     public void resetEncoders(){

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       
    }
        public void setMotorPosition(double speed, int position){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setTargetPosition(position);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        setSpeed(0,speed);
    }
    public void setAllPosition(double speed, double positionRight){
        setMotorPosition(speed, (int) positionRight*720);
       
        while (motorIsBusy()){

        }
        setSpeed(0,0);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
   

    }

       public void setAllPositionCm(double speed, double positionRight){


        setAllPosition(speed, positionRight);
    }
       public boolean motorIsBusy(){

        if (motor.isBusy()){
            return true;
        }
        return false;
    }

}
