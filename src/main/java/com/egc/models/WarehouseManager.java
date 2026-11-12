package com.egc.models;

public class WarehouseManager extends User{

    public WarehouseManager() {
        this("mangager@gmail.com", "admin", "Manager");
    }

    public WarehouseManager(String name, String email, String password, String access) {
        super(name, email, password, access);
    }

    public WarehouseManager(String email, String password, String access) {
        super(email, password, access);
    }
    
}