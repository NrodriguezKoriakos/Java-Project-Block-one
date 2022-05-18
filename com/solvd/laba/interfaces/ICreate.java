package com.solvd.laba.interfaces;

import com.solvd.laba.building.*;
import com.solvd.laba.project.Project;

public interface ICreate {

    Project createBuilding(int option);

    Project createSmallBuilding(String city, int pricePerSquareMeter);

    Project createMediumBuilding(String city, int pricePerSquareMeter);

    Project createLargeBuilding(String city, int pricePerSquareMeter);

    House createHouse(int size, String city);

    EducationalBuilding createEducationalBuilding(int size, String city, int classrooms, int floors);

    Project createProject(Building building, int teamSize, int typeOfBuilding, String city, int floors, int extraCosts);

    Cabin createCabin(int size, String city);

    Museum createMuseum(int size, String city, int galleries, int floors);

    Hospital createHospital(int sizeInSquareMeters, String city, int floors, int elevators,
                            boolean hasParkingLot, int doctorOffice, boolean hasEmergencyRoom);
    Skyscraper createSkyscraper(int sizeInSquareMeters, String city, int floors, int elevators, boolean hasParkingLot
            , int apartments);
}
