package com.artemnizhnyk.junitapp.Motorcyclist;

import com.artemnizhnyk.junitapp.Ammunition.*;

import java.util.List;

public class Customer {

    private List<MotorcycleHelmet> motorcycleHelmetList;
    private List<MotorcycleGloves> motorcycleGlovesList;
    private List<MotorcycleJacket> motorcycleJacketList;
    private List<MotorcycleTrousers> motorcycleTrousersList;
    private List<MotorcycleBoots> motorcycleBootsList;

    private double price;

    public Customer(List<MotorcycleHelmet> motorcycleHelmetList, List<MotorcycleGloves> motorcycleGlovesList, List<MotorcycleJacket> motorcycleJacketList,
                    List<MotorcycleTrousers> motorcycleTrousersList, List<MotorcycleBoots> motorcycleBootsList) {
        this.motorcycleHelmetList = motorcycleHelmetList;
        this.motorcycleGlovesList = motorcycleGlovesList;
        this.motorcycleJacketList = motorcycleJacketList;
        this.motorcycleTrousersList = motorcycleTrousersList;
        this.motorcycleBootsList = motorcycleBootsList;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } // цикл  с  листами


    public double calculateCosts(List<? extends MotorcycleAmmunition> list) {
        double sum = 0;

        for (MotorcycleAmmunition i : list) {
            sum += i.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Customer сhoise: " + "\n" +
                motorcycleHelmetList + "\n" +
                motorcycleGlovesList + "\n" +
                motorcycleJacketList + "\n" +
                motorcycleTrousersList + "\n" +
                motorcycleBootsList;
    }
}
