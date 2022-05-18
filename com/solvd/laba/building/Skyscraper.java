package com.solvd.laba.building;

public class Skyscraper extends LargeBuilding{

    int apartments;
    double apartmentSize;

    public Skyscraper(int sizeInSquareMeters, String city, int floors, int elevators, boolean hasParkingLot, String name, int apartments) {
        super(sizeInSquareMeters, city, floors, elevators, hasParkingLot, name);
        this.apartments = apartments;
        this.apartmentSize = sizeInSquareMeters / apartments;
        this.constructionDuration = 1095;
    }

    @Override
    public void getBuildingInfo() {
        System.out.println("Building project info:\n" +
                "Name of the building: " + this.name + "\n" +
                "Type of building: Skyscraper" + "\n" +
                "City where the project is located: " + getCity() + "\n" +
                "Size of the project: " + getSizeInSquareMeters() + " square meters\n" +
                "Amount of apartments per floor: " + this.apartments + "\n" +
                "Size of apartments: " + this.apartmentSize + " square meters\n" +
                "Floors: " + this.floors + "\n" +
                "Elevators: " + this.elevators + "\n" +
                "Has Parking Lot: " + hasParkingLot());
    }

    private String hasParkingLot(){
        if (this.hasParkingLot){
            return "Yes";
        }
        return "No";
    }


}
