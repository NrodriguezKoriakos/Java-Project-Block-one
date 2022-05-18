package com.solvd.laba.building;

public class Hospital extends LargeBuilding{

    int doctorOffice;
    double doctorOfficeSize;
    boolean hasEmergencyRoom;

    public Hospital(int sizeInSquareMeters, String city, int floors, int elevators,
                    boolean hasParkingLot, String name, int doctorOffice,
                    boolean hasEmergencyRoom) {
        super(sizeInSquareMeters, city, floors, elevators, hasParkingLot, name);
        this.doctorOffice = doctorOffice;
        this.doctorOfficeSize = sizeInSquareMeters / doctorOffice;
        this.hasEmergencyRoom = hasEmergencyRoom;
        this.constructionDuration = 1095;
    }

    @Override
    public void getBuildingInfo() {
        System.out.println("Building project info:\n" +
                "Name of the building: " + this.name + "\n" +
                "Type of building: Hospital" + "\n" +
                "City where the project is located: " + getCity() + "\n" +
                "Size of the project: " + getSizeInSquareMeters() + " square meters\n" +
                "Amount of doctor's office per floor: " + this.doctorOffice + "\n" +
                "Size of doctor's office: " + this.doctorOfficeSize + " square meters\n" +
                "Floors: " + this.floors + "\n" +
                "Elevators: " + this.elevators + "\n" +
                "Has Parking Lot: " + hasParkingLot() + "\n" +
                "Has Emergency room: " + hasEmergencyRoom());
    }

    private String hasParkingLot(){
        if (this.hasParkingLot){
            return "Yes";
        }
        return "No";
    }

    private String hasEmergencyRoom(){
        if (this.hasEmergencyRoom){
            return "Yes";
        }
        return "No";
    }
}
