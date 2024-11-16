package org.example;

import java.util.List;

public class Order {
    private int id;
    private final List<Pizza> pizzas;
    private int customerId;

    public Order(int id, List<Pizza> pizzas, int customerId) {
        this.id = id;
        this.pizzas = pizzas;
        this.customerId = customerId;
    }

    public double calculatePrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        return total;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
