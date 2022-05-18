package com.solvd.laba.building;

public class Museum extends MediumBuilding{

    int galleries;
    double gallerySize;
    public Museum(int sizeInSquareMeters, String city, int floors, String name, int galleries) {
        super(sizeInSquareMeters, city, floors, name);

        this.galleries = galleries;
        this.gallerySize = sizeInSquareMeters / galleries;
        this.constructionDuration = 730;
    }

    @Override
    public void getBuildingInfo() {
        System.out.println("Building project info:\n" +
                "Name of the building: " + this.name + "\n" +
                "Type of building: Museum \n" +
                "City where the project is located: " + getCity() + "\n" +
                "Size of the project: " + getSizeInSquareMeters() + " square meters\n" +
                "Amount of galleries per floor: " + this.galleries + "\n" +
                "Size of galleries: " + this.gallerySize  + " square meters");
    }
}
