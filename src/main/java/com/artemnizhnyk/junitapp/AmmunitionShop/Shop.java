package com.artemnizhnyk.junitapp.AmmunitionShop;

import com.artemnizhnyk.junitapp.Ammunition.*;

import java.util.List;
import java.util.Objects;

public class Shop {

    private List<MotorcycleHelmet> motorcycleHelmetList;
    private List<MotorcycleGloves> motorcycleGlovesList;
    private List<MotorcycleJacket> motorcycleJacketList;
    private List<MotorcycleTrousers> motorcycleTrousersList;
    private List<MotorcycleBoots> motorcycleBootsList;

    public Shop(List<MotorcycleHelmet> motorcycleHelmetList, List<MotorcycleGloves> motorcycleGlovesList, List<MotorcycleJacket> motorcycleJacketList,
                List<MotorcycleTrousers> motorcycleTrousersList, List<MotorcycleBoots> motorcycleBootsList) {
        this.motorcycleHelmetList = motorcycleHelmetList;
        this.motorcycleGlovesList = motorcycleGlovesList;
        this.motorcycleJacketList = motorcycleJacketList;
        this.motorcycleTrousersList = motorcycleTrousersList;
        this.motorcycleBootsList = motorcycleBootsList;
    }

    public List<MotorcycleHelmet> getMotorcycleHelmetList() {
        return motorcycleHelmetList;
    }

    public List<MotorcycleGloves> getMotorcycleGlovesList() {
        return motorcycleGlovesList;
    }

    public List<MotorcycleJacket> getMotorcycleJacketList() {
        return motorcycleJacketList;
    }

    public List<MotorcycleTrousers> getMotorcycleTrousersList() {
        return motorcycleTrousersList;
    }

    public List<MotorcycleBoots> getMotorcycleBootsList() {
        return motorcycleBootsList;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final Shop shop)) return false;
        return Objects.equals(getMotorcycleHelmetList(), shop.getMotorcycleHelmetList()) && Objects.equals(getMotorcycleGlovesList(), shop.getMotorcycleGlovesList()) && Objects.equals(getMotorcycleJacketList(), shop.getMotorcycleJacketList()) && Objects.equals(getMotorcycleTrousersList(), shop.getMotorcycleTrousersList()) && Objects.equals(getMotorcycleBootsList(), shop.getMotorcycleBootsList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMotorcycleHelmetList(), getMotorcycleGlovesList(), getMotorcycleJacketList(), getMotorcycleTrousersList(), getMotorcycleBootsList());
    }

    @Override
    public String toString() {
        return "Shop: " +
                "motorcycleHelmetList=" + motorcycleHelmetList + "\n" +
                " motorcycleGlovesList=" + motorcycleGlovesList + "\n" +
                " motorcycleJacketList=" + motorcycleJacketList + "\n" +
                " motorcycleTrousersList=" + motorcycleTrousersList + "\n" +
                " motorcycleBootsList=" + motorcycleBootsList;
    }
}

