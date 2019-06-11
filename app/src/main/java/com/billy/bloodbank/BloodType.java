package com.billy.bloodbank;

public class BloodType {

    private int id;
    private String blood_type;
    private double units;

    public BloodType(int id, String blood_type, double units){
        this.id = id;
        this.blood_type = blood_type;
        this.units = units;

    }

    public int getId(){
        return id;
    }

    public String getBlood_type(){
        return blood_type;
    }

    public double getUnits(){
        return units;
    }
}
