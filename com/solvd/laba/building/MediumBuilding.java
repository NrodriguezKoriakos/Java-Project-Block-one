package com.solvd.laba.building;

public abstract class MediumBuilding extends Building {

    int floors;
    String name;

    public MediumBuilding(int sizeInSquareMeters, String city, int floors, String name) {
        super(sizeInSquareMeters, city);
        this.floors = floors;
        this.name = name;
    }
}

