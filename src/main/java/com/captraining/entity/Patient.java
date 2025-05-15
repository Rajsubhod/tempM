package com.captraining.entity;

public class Patient extends User{

    public Patient(String id, String name) {
        super(id, name);
    }

    public Patient() {
    }

    @Override
    void showProfile() {
        System.out.println("Patient ID: " + id + ", Patient Name: " + id);
    }
}
