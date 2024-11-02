package org.example;

public class Pizzeria {
    private String name = "The Russo Brothers Pizzeria";

    public String getName() {
        return name;
    }

    public void welcome(){
        System.out.println("Welcome to " + getName() + "How many pizzas would you like to order?");
    }

    public void pizzaPreparation(){
        System.out.println("Pizza has been ordered." + " Preparing pizza...");
    }

}
