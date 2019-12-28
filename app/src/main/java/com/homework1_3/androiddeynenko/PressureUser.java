package com.homework1_3.androiddeynenko;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PressureUser {
    private int upPressure;
    private int downPressure;
    private int pulse;
    private String tachycardia;
    private LocalDateTime date;


    ArrayList<PressureUser> userList = new ArrayList<>();

    public PressureUser(int upPressure, int downPressure, int pulse, String tachycardia,
                        LocalDateTime date) {
        this.upPressure = upPressure;
        this.downPressure = downPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

}
