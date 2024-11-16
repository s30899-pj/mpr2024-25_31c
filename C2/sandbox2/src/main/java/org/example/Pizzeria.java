package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private final String name = "The Russo Brothers Pizzeria";
    private List<Pizza> menu = new ArrayList<>();

    public Pizzeria() {
        initializeMenu();
    }

    private void initializeMenu() {
        menu.add(new Pizza(27.0, "Margherita"));
        menu.add(new Pizza(29.0, "Pepperoni"));
        menu.add(new Pizza(28.0, "Quattro Formaggi"));
    }

    public void orderPizza(Order order) {
        welcome();
        choosePizza(order);
        finalizeOrder(order);
        pizzaPreparation();
    }

    public void welcome(){
        System.out.println("Welcome to " + getName());
    }

    public void choosePizza(Order order) {
        System.out.println("Choose what pizzas you want to order:");
        listOfPizza();
        System.out.println("Pizzas you ordered:");
        for (Pizza pizza : order.getPizzas()) {
            System.out.println("- " + pizza.getName() + ": PLN" + pizza.getPrice());
        }
    }

    public void listOfPizza() {
        System.out.println("Available pizzas:");
        for (Pizza pizza : menu) {
            System.out.println("- " + pizza);
        }
    }

    public void finalizeOrder(Order order) {
        double totalPrice = order.calculatePrice();
        System.out.println("Finalizing order...");
        System.out.println("Total price: PLN" + totalPrice);
    }

    public void pizzaPreparation(){
        System.out.println("Pizza has been ordered. Preparing pizza...\n");
    }

    public String getName() {
        return name;
    }
}
