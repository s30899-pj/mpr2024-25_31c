package pl.pjatk.rental_service;

import java.time.LocalDate;

public class Hire {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private Car car;

    public Hire(int id, String firstName, String lastName, LocalDate startDate, LocalDate endDate, double price, Car car) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
