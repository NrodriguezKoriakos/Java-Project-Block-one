package com.solvd.laba.main;

import com.solvd.laba.company.Company;
import com.solvd.laba.interfaces.IMenu;
import com.solvd.laba.interfaces.IShow;
import com.solvd.laba.project.Project;


import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu implements IMenu, IShow {

    Scanner scanner = new Scanner(System.in);
    Company company = new Company();
    LinkedList<Project> projects = new LinkedList<>();

    @Override
    public void startMenu() {
        int op; // option variable

        try {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\n Please choose an option: \n\n" +
                        "1: See existing Buildings \n" +
                        "2: Create Building \n" +
                        "3: End program\n\n" +
                        "Choose one option(1 or 3): ");
                op = scanner.nextInt();

                if (op < 1 || op > 3) {
                    System.out.println("\n\n\n\n\n\nPlease choose a valid option (1 or 3). \n");
                }
            } while (op < 1 || op > 3);
        } catch (InputMismatchException e) {
            op = 4;
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Please insert a valid value");
        }

        switch (op) {
            case 1:
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                projectGalleryMenu();
                break;
            case 2:
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                this.projects.add(buildingMenu());
                startMenu();
                break;
            case 3:
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Program ended.");
                break;
            case 4:
                startMenu();
                break;
        }
    }


    @Override
    public Project buildingMenu() {
        int option;

        try {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Hello, Welcome to de building simulation program...\n\n" +
                        "Here we are going to calculate how much will it cost to make a building based on the size of it and the amount of people we are hiring. \n" +
                        "First let's select the size of the building \n\n" +
                        "1: Small Building \n" +
                        "2: Medium Building \n" +
                        "3: Large building \n\n" +
                        "Choose one option(1,2,3): ");
                option = scanner.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            } while (option < 1 || option > 3);
        } catch (InputMismatchException e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("Please Insert a valid value \n");
            option = 0;
            startMenu();
        }

       return  company.createBuilding(option);

    }

    @Override
    public void projectGalleryMenu() {


        int option;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.println("\n\nWelcome to the project gallery. \n\n" +
                        "Please choose an option: \n");
                System.out.println("1: Check all projects.\n" +
                        "2: Check Small Building Projects.\n" +
                        "3: Check Medium Building projects. \n" +
                        "4: Check Large Building projects. \n" +
                        "5: Check projects based on New York. \n" +
                        "6: Check projects based on Minsk. \n" +
                        "7: Check projects based on Buenos Aires.\n" +
                        "Choose what you want to do(please remember to pick a number between 1 and 7):");
                option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Please select a valid value");
                option = 0;
                projectGalleryMenu();
            }

        } while (option < 1 || option > 7);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

        switch (option){
            case 1:
                showAllProjects();
                break;
            case 2:
                showSmallProjects();
                break;
            case 3:
                showMediumProjects();
                break;
            case 4:
                showLargeProjects();
                break;
            case 5:
                showNewYorkProjects();
                break;
            case 6:
                showMinskProjects();
                break;
            case 7:
                showBuenosAiresProjects();
                break;
        }

        System.out.println("\n\nGoing back to main menu\n");
        startMenu();

    }

    @Override
    public void showAllProjects() {

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }

        for (Project project : projects) {
            project.getProjectInfo();
            System.out.println("Press Enter to see the next building\n");
            scanner.nextLine();
            System.out.println("--------------------------------------------------");
        }
        System.out.println("There are no more projects");
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void showSmallProjects() {
        int count = 0;

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }

        for (Project project : projects) {
            if (project.getBuilding().getSizeInSquareMeters() <= 500) {
                project.getProjectInfo();
                System.out.println("Press Enter to see the next building\n");
                scanner.nextLine();
                System.out.println("--------------------------------------------------");
                count++;
            }
        }
        if (count == 0){
            System.out.println("There are no small projects found.");
        }
    }

    @Override
    public void showMediumProjects() {
        int count = 0;

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }


        for (Project project : projects) {
            if (project.getBuilding().getSizeInSquareMeters() > 500 &&
                    project.getBuilding().getSizeInSquareMeters() <= 2000) {
                project.getProjectInfo();
                System.out.println("Press Enter to see the next building\n");
                scanner.nextLine();
                System.out.println("--------------------------------------------------");
                count++;
            }
        }
        if (count == 0){
            System.out.println("There are no medium projects found.");
        }
    }

    @Override
    public void showLargeProjects() {
        int count = 0;

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }

        for (Project project : projects) {
            if (project.getBuilding().getSizeInSquareMeters() > 2000) {
                project.getProjectInfo();
                System.out.println("Press Enter to see the next building\n");
                scanner.nextLine();
                System.out.println("--------------------------------------------------");
                count++;
            }
        }
        if (count == 0){
            System.out.println("There are no Large projects found.");
        }
    }

    @Override
    public void showNewYorkProjects() {
        int count = 0;

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }

        for (Project project : projects) {
            if (project.getBuilding().getCity().equals("New York")) {
                project.getProjectInfo();
                System.out.println("Press Enter to see the next building\n");
                scanner.nextLine();
                System.out.println("--------------------------------------------------");
                count++;
            }
        }
        if (count == 0){
            System.out.println("There are no New York projects found.");
        }
    }

    @Override
    public void showMinskProjects() {
        int count = 0;

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }

        for (Project project : projects) {
            if (project.getBuilding().getCity().equals("Minsk")) {
                project.getProjectInfo();
                System.out.println("Press Enter to see the next building\n");
                scanner.nextLine();
                System.out.println("--------------------------------------------------");
                count++;
            }
        }
        if (count == 0){
            System.out.println("There are no Minsk projects found.");
        }


    }

    @Override
    public void showBuenosAiresProjects() {
        int count = 0;

        if (this.projects.isEmpty()){
            System.out.println("There are no projects recorded.\n");
            System.out.println("Returning to Main menu");
            startMenu();
        }

        for (Project project : projects) {
            if (project.getBuilding().getCity().equals("Buenos Aires")) {
                project.getProjectInfo();
                System.out.println("Press Enter to see the next building\n");
                scanner.nextLine();
                System.out.println("--------------------------------------------------");
                count++;

            }
        }
        if (count == 0){
            System.out.println("There are no Buenos Aires projects found.");
        }


    }
}


