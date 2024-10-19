package org.example;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        Pizzeria pizzeria = new Pizzeria();

        pizzeria.welcome();
        pizzeria.numberOfPizzas = 2;
        pizzeria.order.put("Margarita", 40);
        pizzeria.order.put("Quattro Formaggi", 60);
        pizzeria.orderPizza();

    }
}