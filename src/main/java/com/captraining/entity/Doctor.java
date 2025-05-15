package com.captraining.entity;

public class Doctor extends User{

    private boolean available = true;

    public Doctor() {
    }

    public Doctor(String id, String name) {
        super(id, name);
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
