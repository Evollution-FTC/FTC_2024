package org.firstinspires.ftc.teamcode.utils;

public class CooldownBool {

    boolean previousState;

    public CooldownBool(){
      previousState = false;
    }
    public boolean test(boolean state){
        if (state != previousState) {
            previousState = state;
            return state;
        }
        return false;
    }
}
