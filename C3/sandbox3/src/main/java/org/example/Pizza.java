package org.example;

public class Pizza {
    private final double price;
    private final String name;

    public Pizza(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - " + price + "PLN";
    }

}

