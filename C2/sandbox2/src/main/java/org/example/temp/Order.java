package org.example.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    Pizza pizza = new Pizza();
    List<Pizza> pizzas = new ArrayList<Pizza>();



    public void choosePizza() {
        System.out.println("Choose what pizzas you want to order and size of this:");
        pizza.listOfPizza();

        System.out.println("Pizzas you ordered: ");
        for (Map.Entry<String, Integer> e : order.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
