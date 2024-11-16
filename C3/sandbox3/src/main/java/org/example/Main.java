package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Pizzeria pizzeria = new Pizzeria();

        List<Pizza> pizzasToOrder = new ArrayList<>();
        pizzasToOrder.add(new Pizza(27.0, "Margherita"));
        pizzasToOrder.add(new Pizza(29.0, "Pepperoni"));
        Order order = new Order(1, pizzasToOrder, 101);

        List<Pizza> pizzasToOrder2 = new ArrayList<>();
        pizzasToOrder2.add(new Pizza(27.0, "Margherita"));
        pizzasToOrder2.add(new Pizza(28.0, "Quattro Formaggi"));
        Order order2 = new Order(2, pizzasToOrder2, 101);

        pizzeria.orderPizza(order2);
        pizzeria.orderPizza(order);
    }
}