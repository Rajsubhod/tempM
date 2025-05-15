package com.captraining.entity;

abstract public class User {
    protected int id;
    protected String name;

    public User(){}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void showProfile();
}
