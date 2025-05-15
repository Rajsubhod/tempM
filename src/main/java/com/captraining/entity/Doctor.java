package com.captraining.entity;

public class Doctor extends User{

    private boolean available;

    public Doctor() {
    }

    public Doctor(int id, String name, boolean available) {
        super(id, name);
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void showProfile() {
        System.out.println("Doctor ID: " + id + ", Doctor Name: " + name + ", Available: " + available);
    }
}
