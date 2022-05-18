package com.solvd.laba.building;

public class LargeBuilding extends Building{

    int floors;
    int elevators;
    boolean hasParkingLot;
    String name;

    public LargeBuilding(int sizeInSquareMeters, String city, int floors, int elevators, boolean hasParkingLot, String name) {
        super(sizeInSquareMeters, city);
        this.floors = floors;
        this.elevators = elevators;
        this.hasParkingLot = hasParkingLot;
        this.name = name;
    }

}
