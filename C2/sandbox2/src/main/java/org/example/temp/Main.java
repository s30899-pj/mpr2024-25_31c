package org.example.temp;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        Order order1 = new Order();
        Order order2 = new Order();

        pizzeria.orderPizza(order1);
        pizzeria.orderPizza(order2);
    }
}