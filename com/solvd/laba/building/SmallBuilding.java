package com.solvd.laba.building;

public abstract class SmallBuilding extends Building {

    int gardenLength;

    public SmallBuilding(int sizeInSquareMeters, String city, int gardenLength) {
        super(sizeInSquareMeters, city);
        this.gardenLength = gardenLength;
    }

    public int getGardenLength() {
        return gardenLength;
    }
}
