package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Pizzeria {
    private String name = "The Russo Brothers Pizzeria";
    int numberOfPizzas;
    Map<String, Integer> order = new HashMap<>();
    private Pizza pizza = new Pizza();

    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }
    public String getName() {
        return name;
    }
    public Map<String, Integer> getOrder() {
        return order;
    }


    public void welcome(){
        System.out.println("Welcome to " + getName() + "How many pizzas would you like to order?");
    }

    public void orderPizza() {
        choosePizza();
        pizzaPreparation();
    }

    public void choosePizza(){
        System.out.println("You chose " + numberOfPizzas + " pizzas");

        System.out.println("Choose what pizzas you want to order and size of this:");
        pizza.listOfPizza();

        order.put("Margarita", 40);
        order.put("Quattro Formaggi", 60);

        System.out.println("You chose " + numberOfPizzas + " pizzas");
        System.out.println("Pizzas you ordered: ");
        for (Map.Entry<String, Integer> e : order.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public void pizzaPreparation(){
        System.out.println("Pizza has been ordered." + " Preparing pizza...");
    }

}
