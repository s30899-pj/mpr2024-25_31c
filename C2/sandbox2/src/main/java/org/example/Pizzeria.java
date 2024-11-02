package org.example;

public class Pizzeria {
    private final String name = "The Russo Brothers Pizzeria";
    Order order = new Order();

    public String getName() {
        return name;
    }

    public void welcome(){
        System.out.println("Welcome to " + getName() + "How many pizzas would you like to order?");
    }

    public void orderPizza() {
        welcome();
        order.choosePizza();
        pizzaPreparation();
    }

    public void pizzaPreparation(){
        System.out.println("Pizza has been ordered." + " Preparing pizza...");
    }

}
