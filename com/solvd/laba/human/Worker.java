package com.solvd.laba.human;

public class Worker extends Human{

    int yearsOfExperience;

    public Worker( int age, int yearsOfExperience) {
        super(true, age);
        this.yearsOfExperience = yearsOfExperience;

    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }
}
