package com.solvd.laba.human;

import com.solvd.laba.interfaces.IWork;

public class Builder extends Worker implements IWork {

    String name;
    public Builder(String name, int age, int yearsOfExperience) {
        super(true , age, yearsOfExperience);
        this.name = name;
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }


    @Override
    public String getSeniority(){

        if (this.yearsOfExperience < 2){
            return "Jr";
        } else if (this.yearsOfExperience < 5) {
            return  "Ssr";
        } else {
            return "Sr";
        }
    }

    @Override
    public double monthlySalary(){

        String seniority = getSeniority();
        double salaryPerHour = 12.50;
        double salaryModifier;

        if (seniority.equals("Jr")){
            salaryModifier = 1;
        } else if (seniority.equals("Ssr")){ // increments salary based on experience
            salaryModifier=1.5;
        } else {
            salaryModifier=2.2;
        }

        salaryPerHour *= salaryModifier;

        return (salaryPerHour*8) * 20; //(Salary per hours * daily hours) * work days in the month
    }
}
