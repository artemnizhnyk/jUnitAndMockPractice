package com.artemnizhnyk.junitapp.AmmunitionShop;

import com.artemnizhnyk.junitapp.Ammunition.MotorcycleAmmunition;

import java.util.Comparator;

public class ClassComparator implements Comparator<MotorcycleAmmunition> {

    @Override
    public int compare(MotorcycleAmmunition o1, MotorcycleAmmunition o2) {
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        } else if (o1.getWeight() == o2.getWeight()) {
            return 0;
        } else {
            return 1;
        }
    }


}
