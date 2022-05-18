package com.solvd.laba.building;

import com.solvd.laba.interfaces.IGetInfo;

public abstract class Building implements IGetInfo {

    private final int sizeInSquareMeters;
    double constructionDuration;
    private final String city;


    public Building(int sizeInSquareMeters, String city) {
        this.sizeInSquareMeters = sizeInSquareMeters;
        this.city = city;
    }

    public int getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    public String getCity() {
        return city;
    }

    public double getConstructionDuration() {
        return constructionDuration;
    }

    @Override
    public void getBuildingInfo() {
    }
}
