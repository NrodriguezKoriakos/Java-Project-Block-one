package com.solvd.laba.company;

import com.solvd.laba.building.*;
import com.solvd.laba.human.Builder;
import com.solvd.laba.interfaces.IBudget;
import com.solvd.laba.interfaces.ICreate;
import com.solvd.laba.project.Project;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;

public class Company implements ICreate, IBudget {


    @Override
    public Project createBuilding(int option) {

        if (option == 1) {
            System.out.println("\n\nYou chose to create a small building...");
            System.out.println("\n");
        } else if (option == 2) {
            System.out.println("\n\nYou chose to create a medium building...");
            System.out.println("\n");
        } else if (option == 3) {
            System.out.println("\n\nYou chose to create a large building...");
            System.out.println("\n");
        }

        return calculateBudget(option);
    }

    @Override
    public Project calculateBudget(int option) {

        Scanner scanner = new Scanner(System.in);

        int option2;
        try {
            do {
                System.out.println("In order to create your building we need to know where do you want it and \n" +
                        "the size of the surface that you want to cover in square meters");
                System.out.println("First let's select the city \n\n" +
                        "1 = New York - 1300 U$D(price per square meter in this city)\n" +
                        "2 = Minsk - 800 U$D(price per square meter in this city) \n" +
                        "3 = Buenos Aires - 450 U$D(price per square meter in this city) \n" +
                        "Choose one option(1,2,3): ");
                option2 = scanner.nextInt();

                if (option2 != 1 && option2 != 2 && option2 != 3) {
                    System.out.println("\n\n\n\n\n\n\n\n\nPlease select a valid option (1,2,3)\n");
                }
            } while (option2 != 1 && option2 != 2 && option2 != 3);
            System.out.println("\n\n");

            // Set the values chosen by de user
            String city;
            int pricePerSquareMeter;

            if (option2 == 1) {
                city = "New York";
                pricePerSquareMeter = 1300;
            } else if (option2 == 2) {
                city = "Minsk";
                pricePerSquareMeter = 800;
            } else {
                city = "Buenos Aires";
                pricePerSquareMeter = 450;
            }

            if (option == 1) {
                return createSmallBuilding(city, pricePerSquareMeter);
            } else if (option == 2) {
               return  createMediumBuilding(city, pricePerSquareMeter);
            } else {
                return createLargeBuilding(city, pricePerSquareMeter);
            }

        } catch (InputMismatchException e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("Please Insert a valid value \n\n");
            return calculateBudget(option);
        }
    }

    @Override
    public Project createSmallBuilding(String city, int pricePerSquareMeter) {

        System.out.println("\n\n\n");

        int size;

        System.out.println("Great, so you chose a small building in " + city);
        System.out.println("Now is time to chose the size of the surface that you want to cover." +
                "\nSmall buildings have a minimum size of 50 square meters and a maximum of 500 square meters \n\n");

        size = buildingSize(1);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Now that we know your city and the size of your building is time to choose which kind of building we are making.\n" +
                "You choose small building so you have this options: House and Cabin \n\n" +
                "Houses need at least 8 builders so they are more expensive then Cabins. \n\n" +
                "The amount of builders that you have impacts directly on the costs and length of the project.\n" +
                "For example: If you have 1 builder you may take 1 year to make a cabin but if you have 2 builders it will take half the time.\n" +
                "Houses need at least 8 builders and take 1 year to make with that amount of builders, cabins need 1 builder and take 1 year to make.");

        int option;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choose your building:\n" +
                        "1 - House\n" +
                        "2 - Cabin");
                option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.print("Please Insert a valid value \n");
                option = 0;

            }
        } while (option != 1 && option != 2);

        int teamSize;

        if (option == 1) {

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You chose to build a house");
                    System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                            "but it also means that is going to cost more.\n");
                    System.out.println("Team Size(each team has 8 builders): ");
                    teamSize = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    teamSize = 0;
                }
            } while (teamSize<=0);

            Project project = createProject(createHouse(size, city), teamSize, 1, city, 1, 0);

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your project was successfully created.\n");
            System.out.println("Returning to main menu...");

            return  project;


        } else {
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You chose to build a cabin");
                    System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                            "but it also means that is going to cost more.\n");
                    System.out.println("Team Size(each team has 1 builder): ");
                    teamSize = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    teamSize = 0;
                }
            } while (teamSize<=0);

            Project project = createProject(createCabin(size, city), teamSize, 1, city, 1, 0);

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your project was successfully created.\n");
            System.out.println("Returning to main menu...");

            return  project;
        }
    }

    @Override
    public Project createMediumBuilding(String city, int pricePerSquareMeter) {
        System.out.println("\n\n\n");

        int size;

        System.out.println("Great, so you chose a medium building in " + city);
        System.out.println("Now is time to chose the size of the surface that you want to cover." +
                "\nmedium buildings have a minimum size of 501 square meters and a maximum of 2000 square meters \n\n");

        size = buildingSize(2);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Now that we know your city and the size of your building is time to choose which kind of building we are making.\n" +
                "You choose medium building so you have this options: Educational Building and Museum \n\n" +
                "The amount of builders that you have impacts directly on the costs and length of the project.\n" +
                "For example: If you have 1 builder you may take 1 year to make a cabin but if you have 2 builders it will take half the time.\n");

        int option;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choose your building:\n" +
                        "1 - Educational Building(Needs a minimum of 25 builders)\n" +
                        "2 - Museum(Needs a minimum of 50 builders)");
                option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.print("Please Insert a valid value \n");
                option = 0;

            }
        } while (option != 1 && option != 2);

        int teamSize;
        int classRooms;
        int floors;
        int galleries;

        if (option == 1) {

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You chose to build a Educational Building");
                    System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                            "but it also means that is going to cost more.\n");
                    System.out.println("Team Size(each team has 25 builders): ");
                    teamSize = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n\n");
                    teamSize = 0;
                }
            } while (teamSize<=0);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many classrooms will your Educational building have(Min 5 max 20):");
                    classRooms = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    classRooms = 0;
                }
            } while (classRooms < 5 || classRooms > 20);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many floors will your Educational building have(Min 1 max 3):");
                    floors = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    floors = 0;
                }
            } while (floors < 1 || floors > 3);
            Project project = createProject(createEducationalBuilding(size, city, classRooms, floors), teamSize, 3, city, floors, 0);

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your project was successfully created.\n");
            System.out.println("Returning to main menu...");

            return  project;


        } else {
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You chose to build a Museum");
                    System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                            "but it also means that is going to cost more.\n");
                    System.out.println("Team Size(each team has 50 builders): ");
                    teamSize = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n\n");
                    teamSize = 0;
                }
            } while (teamSize<=0);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many galleries will your Museum have(Min 12 max 30):");
                    galleries = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    galleries = 0;
                }
            } while (galleries < 12 || galleries > 30);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many floors will your Museum have(Min 1 max 7):");
                    floors = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    floors = 0;
                }
            } while (floors < 1 || floors > 7);
            Project project = createProject(createMuseum(size, city, galleries, floors), teamSize, 4, city, floors, 0);

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your project was successfully created.\n");
            System.out.println("Returning to main menu...");

            return  project;


        }
    }

    @Override
    public Project createLargeBuilding(String city, int pricePerSquareMeter) {
        System.out.println("\n\n\n");

        int size;

        System.out.println("Great, so you chose a large building in " + city);
        System.out.println("Now is time to chose the size of the surface that you want to cover." +
                "\nlarge buildings have a minimum size of 2001 square meters and has no maximum size\n\n");

        size = buildingSize(3);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Now that we know your city and the size of your building is time to choose which kind of building we are making.\n" +
                "You choose large building so you have this options: Skyscraper and Hospital \n\n" +
                "The amount of builders that you have impacts directly on the costs and length of the project.\n" +
                "For example: If you have 1 builder you may take 1 year to make a cabin but if you have 2 builders it will take half the time.\n");

        int option;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choose your building:\n" +
                        "1 - Skyscraper(Needs a minimum of 75 builders)\n" +
                        "2 - Hospital(Needs a minimum of 100 builders)");
                option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.print("Please Insert a valid value \n");
                option = 0;

            }
        } while (option != 1 && option != 2);

        int teamSize;
        int apartments;
        int floors;
        int offices;
        int elevators;
        boolean parkingLot;
        int parking;
        boolean emergencyRoom;
        int emergencyR;

        if (option == 1) {

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You chose to build a Skyscraper");
                    System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                            "but it also means that is going to cost more.\n");
                    System.out.println("Team Size(each team has 75 builders): ");
                    teamSize = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n\n");
                    teamSize = 0;
                }
            } while (teamSize<=0);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many apartments will your skyscraper have per floor(Min 10 max 20):");
                    apartments = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    apartments = 0;
                }
            } while (apartments < 10 || apartments > 20);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many floors will your Skyscraper have(Min 12 max 50):");
                    floors = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    floors = 0;
                }
            } while (floors < 12 || floors > 50);

            do{
                try{Scanner scanner = new Scanner(System.in);
                    System.out.println("Each elevator costs 100000, so this adds up to the total cost of the project.");
                    System.out.println("Please choose how many elevators your skyscraper will have (Min 1 max 3):");
                    elevators = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    elevators = 0;
                }
            } while (elevators < 1 || elevators > 3);

            do{
                try{Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose if your skyscraper will have a parking lot (this rises the total cost by U$D 1000000)\n" +
                            "1- Yes\n" +
                            "2- No\n" +
                            "\n" +
                            "please insert your choice: ");
                    parking = scanner.nextInt();
                    System.out.println("\n\n");

                    parkingLot = parking == 1;
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    parking = 0;
                    parkingLot = false;
                }
            } while (parking < 1 || parking > 2);
            Project project = createProject(createSkyscraper(size, city, floors, elevators, parkingLot, apartments)
                    , teamSize, 5, city, floors,calculateExtraCost(elevators,parkingLot, false));

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your project was successfully created.\n");
            System.out.println("Returning to main menu...");

            return  project;


        } else {
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You chose to build a Hospital");
                    System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                            "but it also means that is going to cost more.\n");
                    System.out.println("Team Size(each team has 100 builders): ");
                    teamSize = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n\n");
                    teamSize = 0;
                }
            } while (teamSize <= 0);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many Doctor's office your Hospital will have per floor (Min 5 max 30):");
                    offices = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    offices = 0;
                }
            } while (offices < 5 || offices > 30);

            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose how many floors will your Hospital have(Min 3 max 20):");
                    floors = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    floors = 0;
                }
            } while (floors < 3 || floors > 20);


            do{
                try{Scanner scanner = new Scanner(System.in);
                    System.out.println("Each elevator costs 100000, so this adds up to the total cost of the project.");
                    System.out.println("Please choose how many elevators your hospital will have (Min 1 max 8):");
                    elevators = scanner.nextInt();
                    System.out.println("\n\n");
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    elevators = 0;
                }
            } while (elevators < 1 || elevators > 8);

            do{
                try{Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose if your hospital will have a parking lot (this rises the total cost by U$D 1000000)\n" +
                            "1- Yes\n" +
                            "2- No\n" +
                            "\n" +
                            "please insert your choice: ");
                    parking = scanner.nextInt();
                    System.out.println("\n\n");

                    parkingLot = parking == 1;
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    parking = 0;
                    parkingLot = false;
                }
            } while (parking < 1 || parking > 2);

            do{
                try{Scanner scanner = new Scanner(System.in);
                    System.out.println("Please choose if your hospital will have an Emergency Room (this rises the total cost by U$D 2000000)\n" +
                            "1- Yes\n" +
                            "2- No\n" +
                            "\n" +
                            "please insert your choice: ");
                    emergencyR = scanner.nextInt();
                    System.out.println("\n\n");

                    emergencyRoom = emergencyR == 1;
                } catch (InputMismatchException e) {
                    System.out.print("Please Insert a valid value \n");
                    emergencyR = 0;
                    emergencyRoom = false;
                }
            } while (emergencyR < 1 || emergencyR > 2);
            Project project = createProject(createHospital(size,city,floors,elevators,parkingLot,offices,emergencyRoom)
                    , teamSize, 4, city, floors,calculateExtraCost(elevators,parkingLot,emergencyRoom));


            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your project was successfully created.\n");
            System.out.println("Returning to main menu...");

            return project;

        }
    }

    // the following method is used to check that the size of the building
    private int buildingSize(int typeOfBuilding) {

        Scanner scanner = new Scanner(System.in);
        int size;

        if (typeOfBuilding == 1) {
            try {
                do {
                    System.out.println("Please choose the size of your building (remember that it must be between 50 and 500 meters)");
                    size = scanner.nextInt();
                } while (size < 50 || size > 500);
            } catch (InputMismatchException e) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.print("Please Insert a valid value \n");
                size = 0;
                buildingSize(typeOfBuilding);
            }
        } else if (typeOfBuilding==2){
            try {
                do {
                    System.out.println("Please choose the size of your building (remember that it must be between 501 and 2000 meters)");
                    size = scanner.nextInt();
                } while (size < 501 || size > 2000);
            } catch (InputMismatchException e) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.print("Please Insert a valid value \n");
                size = 0;
                buildingSize(typeOfBuilding);
            }
        } else {
                try {
                    do {
                        System.out.println("Please choose the size of your building (remember that it must be grater then 2000):");
                        size = scanner.nextInt();
                    } while (size < 2001);
                } catch (InputMismatchException e) {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.print("Please Insert a valid value \n");
                    size = 0;
                    buildingSize(typeOfBuilding);
                }
            }

        return size;
    }


    @Override
    public House createHouse(int size, String city) {
        return  new House(size,city);
    }

    @Override
    public Cabin createCabin(int size, String city) {
        return new Cabin(size, city);
    }

    @Override
    public EducationalBuilding createEducationalBuilding(int size, String city, int classrooms, int floors) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a name for your new educational building: ");
        String name = scanner.nextLine();
        return new EducationalBuilding(size, city, classrooms, name ,floors);
    }

    @Override
    public Project createProject(Building building, int teamSize, int typeOfBuilding, String city, int floors, int extraCosts) {

        building.getBuildingInfo();
        if (typeOfBuilding==1) {
            int buildersCost = 0;
            int amountOfBuilders = 8 * teamSize; //Each team has at least 8 builders
            double constructionDuration = building.getConstructionDuration() / teamSize;

            for (int i = 0; i != amountOfBuilders; i++) {
                Builder builder = new Builder("Anonymous", 18, 1);
                buildersCost += builder.monthlySalary();
            }

            int pricePerSquareMeter;

            if (city.equals("New York")) {
                pricePerSquareMeter = 1300;
            } else if (city.equals("Minsk")) {
                pricePerSquareMeter = 800;
            } else {
                pricePerSquareMeter = 450;
            }
            double constructionCost = building.getSizeInSquareMeters() * pricePerSquareMeter;

            BigDecimal totalCost = new BigDecimal(constructionCost + buildersCost);

            return new Project(building, teamSize , constructionDuration, totalCost);

        } else if (typeOfBuilding==2) {
            int buildersCost = 0;
            double constructionDuration = building.getConstructionDuration() / teamSize;

            for (int i = 0; i != teamSize; i++) {
                Builder builder = new Builder("Anonymous", 18, 1);
                buildersCost += builder.monthlySalary();
            }

            int pricePerSquareMeter;

            if (city.equals("New York")) {
                pricePerSquareMeter = 1300;
            } else if (city.equals("Minsk")) {
                pricePerSquareMeter = 800;
            } else {
                pricePerSquareMeter = 450;
            }
            double constructionCost = building.getSizeInSquareMeters() * pricePerSquareMeter;

            BigDecimal totalCost = new BigDecimal(constructionCost + buildersCost);

            return new Project(building, teamSize , constructionDuration, totalCost);
        } else if (typeOfBuilding==3) {

            int buildersCost = 0;
            int amountOfBuilders = 25 * teamSize; //Each team has at least 25 builders
            double constructionDuration = building.getConstructionDuration() / teamSize;

            for (int i = 0; i != amountOfBuilders; i++) {
                Builder builder = new Builder("Anonymous", 28, 3);
                buildersCost += builder.monthlySalary();
            }

            int pricePerSquareMeter;

            if (city.equals("New York")) {
                pricePerSquareMeter = 1300;
            } else if (city.equals("Minsk")) {
                pricePerSquareMeter = 800;
            } else {
                pricePerSquareMeter = 450;
            }
            double constructionCost = (building.getSizeInSquareMeters() * pricePerSquareMeter) * floors;

            BigDecimal totalCost = new BigDecimal(constructionCost + buildersCost);

            return new Project(building, teamSize , constructionDuration, totalCost);
        } else if (typeOfBuilding==4){
            int buildersCost = 0;
            int amountOfBuilders = 50 * teamSize; //Each team has at least 50 builders
            double constructionDuration = building.getConstructionDuration() / teamSize;

            for (int i = 0; i != amountOfBuilders; i++) {
                Builder builder = new Builder("Anonymous", 28, 3);
                buildersCost += builder.monthlySalary();
            }

            int pricePerSquareMeter;

            if (city.equals("New York")) {
                pricePerSquareMeter = 1300;
            } else if (city.equals("Minsk")) {
                pricePerSquareMeter = 800;
            } else {
                pricePerSquareMeter = 450;
            }
            double constructionCost = (building.getSizeInSquareMeters() * pricePerSquareMeter) * floors;

            BigDecimal totalCost =  new BigDecimal(constructionCost + buildersCost);

            return new Project(building, teamSize , constructionDuration, totalCost);

        } else if (typeOfBuilding==5) {
            int buildersCost = 0;
            int amountOfBuilders = 75 * teamSize; //Each team has at least 50 builders
            double constructionDuration = building.getConstructionDuration() / teamSize;

            for (int i = 0; i != amountOfBuilders; i++) {
                Builder builder = new Builder("Anonymous", 35, 8);
                buildersCost += builder.monthlySalary();
            }

            int pricePerSquareMeter;

            if (city.equals("New York")) {
                pricePerSquareMeter = 1300;
            } else if (city.equals("Minsk")) {
                pricePerSquareMeter = 800;
            } else {
                pricePerSquareMeter = 450;
            }
            double constructionCost = (building.getSizeInSquareMeters() * pricePerSquareMeter) * floors;

            BigDecimal totalCost = new BigDecimal(constructionCost + buildersCost + extraCosts) ;

            return new Project(building, teamSize, constructionDuration, totalCost);
        }

        return null;

    }


    @Override
    public Museum createMuseum(int size, String city, int galleries, int floors) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a name for your new museum: ");
        String name = scanner.nextLine();
        return new Museum(size, city, floors, name,galleries);
    }

    @Override
    public Hospital createHospital(int sizeInSquareMeters, String city, int floors, int elevators, boolean hasParkingLot,
                                   int doctorOffice, boolean hasEmergencyRoom) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a name for your new Hospital: ");
        String name = scanner.nextLine();
        return new Hospital(sizeInSquareMeters, city, floors, elevators, hasParkingLot, name, doctorOffice, hasEmergencyRoom);
    }

    @Override
    public Skyscraper createSkyscraper(int sizeInSquareMeters, String city, int floors, int elevators, boolean hasParkingLot,
                                       int apartments) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a name for your new Skyscraper: ");
        String name = scanner.nextLine();
        return new Skyscraper(sizeInSquareMeters, city, floors, elevators, hasParkingLot, name, apartments);
    }

    public int calculateExtraCost(int elevators, boolean parkingLot, boolean emergencyRoom){

        int totalExtraCost = 0;

        totalExtraCost += elevators * 100000;

        if (parkingLot){
            totalExtraCost += 1000000;
        }

        if (emergencyRoom){
            totalExtraCost += 2000000;
        }

        return totalExtraCost;
    }
}

