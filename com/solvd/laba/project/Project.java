package com.solvd.laba.project;

import com.solvd.laba.building.Building;

import java.math.BigDecimal;
public class Project {

    Building building;
    int teamSize;
    double timeToComplete;
    BigDecimal price;

    public Project(Building building, int teamSize, double timeToComplete, BigDecimal price) {
        this.building = building;
        this.teamSize = teamSize;
        this.timeToComplete = timeToComplete;
        this.price = price;
    }

    public Building getBuilding() {
        return building;
    }

    public void getProjectInfo(){
        this.building.getBuildingInfo();
        System.out.println("Team size: " + this.teamSize + "\n" +
                "Time to complete project: " + this.timeToComplete + " days\n" +
                "Price of the project: U$D " + this.price);
        System.out.println("------------------------------------------------------");
    }
}
