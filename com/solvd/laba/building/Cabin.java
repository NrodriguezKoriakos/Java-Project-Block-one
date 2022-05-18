package com.solvd.laba.building;

public class Cabin extends SmallBuilding{


    public Cabin(int sizeInSquareMeters, String city) {
        super(sizeInSquareMeters, city, sizeInSquareMeters/4);
        this.constructionDuration= 365; // construction duration in days
    }

    @Override
    public void getBuildingInfo() {
        System.out.println("Building project info:\n" +
                "Type of building: Cabin \n" +
                "City where the project is located: " + getCity() + "\n" +
                "Size of the project: " + getSizeInSquareMeters() + " square meters\n" +
                "Garden length: " + getGardenLength() + " square meters");
    }
}
