package com.captraining.entity;

abstract public class User {
    protected String id;
    protected String name;

    public User(){}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void showProfile();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
