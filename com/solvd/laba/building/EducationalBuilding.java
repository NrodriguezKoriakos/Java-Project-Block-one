package com.solvd.laba.building;

public class EducationalBuilding extends MediumBuilding{

    int classrooms;
    double classroomSize;

    public EducationalBuilding(int sizeInSquareMeters, String city, int floors, String name, int classrooms) {
        super(sizeInSquareMeters, city, floors, name);

        this.classrooms = classrooms;
        this.classroomSize = sizeInSquareMeters / classrooms;
        constructionDuration = 730;
    }

    @Override
    public void getBuildingInfo() {
        System.out.println("Building project info:\n" +
                "Name of the building: " + this.name + "\n" +
                "Type of building: Educational Building \n" +
                "City where the project is located: " + getCity() + "\n" +
                "Size of the project: " + getSizeInSquareMeters() + " square meters\n" +
                "Amount of classrooms per floor: " + this.classrooms + "\n" +
                "Size of classrooms: " + this.classroomSize + " square meters\n" +
                "Floors: " + this.floors);
    }
}
