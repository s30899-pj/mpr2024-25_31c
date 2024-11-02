package org.example.temp;

import java.util.List;
import java.util.Map;

public class Pizzeria {
    private String name = "The Russo Brothers Pizzeria";
    private final List<String> menu = List.of("Margarita", "Calabresa", "Quattro Formaggi");
    private final List<Integer> size = List.of(30, 40, 50, 60);

    public List<Integer> getSize() {
        return size;
    }

    public List<String> getName() {
        return name;
        return menu;
    }

    public void welcome(){
        System.out.println("Welcome to " + getName() + "How many pizzas would you like to order?");
    }

    public void orderPizza(Order choose) {
        welcome();
        order.choosePizza(choose);
        pizzaPreparation();
    }

    public void pizzaPreparation(){
        System.out.println("Pizza has been ordered." + " Preparing pizza...");
    }

}
