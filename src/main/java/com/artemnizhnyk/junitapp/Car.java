package com.artemnizhnyk.junitapp;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String identificationNumber;
    private int year;
    private String owner;
    private List<String> owners;

    public Car(final String brand, final String identificationNumber, final int year, final String owner) {
        this.brand = brand;
        this.identificationNumber = identificationNumber;
        this.year = year;
        this.owner = owner;
        owners = new ArrayList<>();
        owners.add(owner);
    }

    public String getBrand() {
        return brand;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(final String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public int getYear() {
        return year;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        owners.add(owner);
        this.owner = owner;
    }


    public List<String> getOwners() {
        return owners;
    }

    private String testPrivateMethod(){
        return "abc";
    }
    public int testInt(int a){
        return a+4;
    }

    public String getDataFromRemoteServer() throws Exception {

        throw new Exception("error!!!");


    }
}
