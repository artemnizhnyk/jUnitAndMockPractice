package com.artemnizhnyk.junitapp.Ammunition;

import java.util.Objects;

public abstract class MotorcycleAmmunition<t> {

    private String name;
    private String manufacturer;
    private double price;
    private double weight;

    public MotorcycleAmmunition(String name, String manufacturer, double price, double weight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ": " + manufacturer + ": " + "Price: " + price + " Weight: " + weight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final MotorcycleAmmunition<?> that)) return false;
        return Double.compare(getPrice(), that.getPrice()) == 0 && Double.compare(getWeight(), that.getWeight()) == 0 && Objects.equals(getName(), that.getName()) && Objects.equals(getManufacturer(), that.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getManufacturer(), getPrice(), getWeight());
    }

    public boolean isPricePositive() {

        if (this.price > 0) {
            return true;
        }
        return false;
    }

    public boolean isWeightPositive() {

        if (this.weight > 0) {
            return true;
        }
        return false;
    }
}
