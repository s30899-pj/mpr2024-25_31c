package org.example;

import java.util.List;

public class Pizza {
    private final List<String> name = List.of("Margarita", "Calabresa", "Quattro Formaggi");
    private final List<Integer> size = List.of(30, 40, 50, 60);


    public List<Integer> getSize() {
        return size;
    }

    public List<String> getName() {
        return name;
    }

    public void listOfPizza() {
        for (String i : getName()) {
            System.out.println(i);
            for (Integer j : getSize()) {
                System.out.println(j);
            }
        }
    }
}

