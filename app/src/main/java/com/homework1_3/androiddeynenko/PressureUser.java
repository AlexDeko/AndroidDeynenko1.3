package com.homework1_3.androiddeynenko;

import java.time.LocalDateTime;

public class PressureUser {
    private int upPressure;
    private int downPressure;
    private int pulse;
    private String tachycardia;
    private LocalDateTime date;


    public PressureUser(int upPressure, int downPressure, int pulse, String tachycardia,
                        LocalDateTime date) {
        this.upPressure = upPressure;
        this.downPressure = downPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

}
