package com.artemnizhnyk.junitapp.Main;


import com.artemnizhnyk.junitapp.Ammunition.*;
import com.artemnizhnyk.junitapp.AmmunitionShop.ActionWithAmmunition;
import com.artemnizhnyk.junitapp.AmmunitionShop.Shop;
import com.artemnizhnyk.junitapp.Motorcyclist.Customer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop(helmetsList(), glovesList(), jacketList(), trousersList(), bootsList());

        ActionWithAmmunition actionWithAmmunition = new ActionWithAmmunition(shop);

        System.out.println("Helmets");
        actionWithAmmunition.showItemsInfo(helmetsList());

        List<MotorcycleHelmet> helmet = (List<MotorcycleHelmet>) actionWithAmmunition.selectAmmunition(shop.getMotorcycleHelmetList());

        System.out.println("Jackets");
        actionWithAmmunition.showItemsInfo(jacketList());
        List<MotorcycleJacket> jacket = (List<MotorcycleJacket>) actionWithAmmunition.selectAmmunition(shop.getMotorcycleJacketList());

        System.out.println("Gloves");
        actionWithAmmunition.showItemsInfo(glovesList());
        List<MotorcycleGloves> gloves = ((List<MotorcycleGloves>) actionWithAmmunition.selectAmmunition(shop.getMotorcycleGlovesList()));

        System.out.println("Trousers");
        actionWithAmmunition.showItemsInfo(trousersList());
        List<MotorcycleTrousers> trousers = ((List<MotorcycleTrousers>) actionWithAmmunition.selectAmmunition(shop.getMotorcycleTrousersList()));

        System.out.println("Boots");
        actionWithAmmunition.showItemsInfo(bootsList());
        List<MotorcycleBoots> boots = ((List<MotorcycleBoots>) actionWithAmmunition.selectAmmunition(shop.getMotorcycleBootsList()));

        System.out.println("Sorted by weight, each type of ammunition");
        actionWithAmmunition.sortByWeight(shop.getMotorcycleHelmetList());
        actionWithAmmunition.sortByWeight(shop.getMotorcycleJacketList());
        actionWithAmmunition.sortByWeight(shop.getMotorcycleGlovesList());
        actionWithAmmunition.sortByWeight(shop.getMotorcycleTrousersList());
        actionWithAmmunition.sortByWeight(shop.getMotorcycleBootsList());

        actionWithAmmunition.showItemsInfo(shop.getMotorcycleHelmetList());
        actionWithAmmunition.showItemsInfo(shop.getMotorcycleJacketList());
        actionWithAmmunition.showItemsInfo(shop.getMotorcycleGlovesList());
        actionWithAmmunition.showItemsInfo(shop.getMotorcycleTrousersList());
        actionWithAmmunition.showItemsInfo(shop.getMotorcycleBootsList());

        //итемы в диапазоне цен
        System.out.println("Please enter min/max price");
        actionWithAmmunition.findAndShowItemsInRangePrice(helmetsList());

        System.out.println("Please enter min/max price");
        actionWithAmmunition.findAndShowItemsInRangePrice(jacketList());

        System.out.println("Please enter min/max price");
        actionWithAmmunition.findAndShowItemsInRangePrice(glovesList());

        System.out.println("Please enter min/max price");
        actionWithAmmunition.findAndShowItemsInRangePrice(trousersList());

        System.out.println("Please enter min/max price");
        actionWithAmmunition.findAndShowItemsInRangePrice(bootsList());

        Customer customer = new Customer(helmet, gloves, jacket, trousers, boots);
        System.out.println(customer.toString());

        double sum = customer.calculateCosts(helmet) + customer.calculateCosts(gloves) + customer.calculateCosts(jacket) + // так можно делать??
                customer.calculateCosts(trousers) + customer.calculateCosts(boots);

        customer.setPrice(sum);
        System.out.println("The total cost of the kit chosen by the client: " + customer.getPrice());
    }

    public static List<MotorcycleHelmet> helmetsList() {

        List<MotorcycleHelmet> motorcycleHelmets = new ArrayList<>();
        motorcycleHelmets.add(new MotorcycleHelmet("Helm", "Shoei Neotec", 10, 30, "Polyurethane", "Plastic"));
        motorcycleHelmets.add(new MotorcycleHelmet("Helm", "Shark Evo", 2220, 20, "Polyurethane", "Plastic"));
        motorcycleHelmets.add(new MotorcycleHelmet("Helm", "HJC", 30, 10, "Glass", "Plastic"));

        return motorcycleHelmets;
    }

    public static List<MotorcycleGloves> glovesList() {

        List<MotorcycleGloves> motorcycleGloves = new ArrayList<>();
        motorcycleGloves.add(new MotorcycleGloves("Gloves", "Acerbis", 10, 10, "S", "Cotton"));
        motorcycleGloves.add(new MotorcycleGloves("Gloves", "AFX North America Inc.", 2320, 220, "M", "Cotton"));
        motorcycleGloves.add(new MotorcycleGloves("Gloves", "Alpinestars", 30, 30, "L", "Cotton"));

        return motorcycleGloves;
    }

    public static List<MotorcycleJacket> jacketList() {

        List<MotorcycleJacket> motorcycleJackets = new ArrayList<>();
        motorcycleJackets.add(new MotorcycleJacket("Jacket", "AFX North America Inc.", 10, 110, "S", "Red", "Skin"));
        motorcycleJackets.add(new MotorcycleJacket("Jacket", "Alpinestars", 20, 20, "M", "Blue", "Skin"));
        motorcycleJackets.add(new MotorcycleJacket("Jacket", "AGV", 30, 30, "L", "Yellow", "Skin"));

        return motorcycleJackets;
    }

    public static List<MotorcycleTrousers> trousersList() {

        List<MotorcycleTrousers> motorcycleTrousers = new ArrayList<>();
        motorcycleTrousers.add(new MotorcycleTrousers("Trousers", "Alpinestars", 10, 120, "S", "Red", "Skin"));
        motorcycleTrousers.add(new MotorcycleTrousers("Trousers", " AGV ", 20, 202, "M", "Blue", "Skin"));
        motorcycleTrousers.add(new MotorcycleTrousers("Trousers", "AFX North America Inc.", 20, 30, "L", "Yellow", "Skin"));

        return motorcycleTrousers;
    }

    public static List<MotorcycleBoots> bootsList() {

        List<MotorcycleBoots> motorcycleBoots = new ArrayList<>();
        motorcycleBoots.add(new MotorcycleBoots("Boots", " AGV", 10, 20, 42, "Zipper", "Red"));
        motorcycleBoots.add(new MotorcycleBoots("Boots", "AFX North America Inc.", 20, 30, 43, "Rivet fastener", "Blue"));
        motorcycleBoots.add(new MotorcycleBoots("Boots", "Answer Racing", 30, 30, 44, "Zipper", "Yellow"));

        return motorcycleBoots;
    }

}
