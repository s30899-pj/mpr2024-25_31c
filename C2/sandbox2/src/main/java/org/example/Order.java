package org.example;

import java.util.HashMap;
import java.util.Map;

public class Order {
    int numberOfPizzas;
    Pizza pizza = new Pizza();
    Map<String, Integer> order = new HashMap<>();

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
}
