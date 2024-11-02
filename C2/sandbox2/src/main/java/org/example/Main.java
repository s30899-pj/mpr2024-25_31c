package org.example;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Pizzeria pizzeria = new Pizzeria();

        order.numberOfPizzas = 2;
        order.order.put("Margarita", 40);
        order.order.put("Quattro Formaggi", 60);
        pizzeria.orderPizza();
    }
}