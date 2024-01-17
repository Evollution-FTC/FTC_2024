package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class Crochet {

        boolean _state = false;

        private Servo crochetRight;
        private Servo crochetLeft;

        public Crochet(Servo crochetRight, Servo crochetLeft){
            this.crochetRight = crochetRight;
            this.crochetLeft = crochetLeft;
        }

        public void setAngleRight(double angle){
            crochetRight.setPosition(angle/180);
        }
        public void setAngleLeft(double angle){
            crochetLeft.setPosition(angle/180);
        }
        public double getAngleRight(){
        return (crochetRight.getPosition());
    }
    public double getAngleLeft(){
        return (crochetLeft.getPosition());
    }
    public void switchState(){
        setState(!_state);
    }
    public void setState(boolean state){
        _state = state;
        if (_state) {
            crochetRight.setPosition(.5);
            crochetLeft.setPosition(0);
        }else{
            crochetRight.setPosition(0);
            crochetLeft.setPosition(.5);
        }
    }
}
