package com.solvd.laba.human;

public abstract class Human {

    private final boolean alive;
    private final int age;

    public Human(boolean alive, int age) {
        this.alive = alive;
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getAge() {
        return age;
    }
}
