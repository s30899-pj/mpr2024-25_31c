package pl.pjatk.rental_service;

import org.springframework.stereotype.Component;
import pl.pjatk.rental_service.storage.CarStorage;

@Component
public class RentalOffice {
    private final CarStorage carStorage;
    private final String name = "Car NET";

    public RentalOffice(CarStorage carStorage) {
        this.carStorage = carStorage;
    }

    public void hireCar(Hire hire) {
        welcome();
        chooseCar(hire);
        finalizeHire(hire);
        carRelease();
    }

    public void welcome() {
        System.out.println("Welcome to " + getName());
    }

    public void chooseCar(Hire hire) {
        System.out.println("Choose what car you want to hire:");
        carStorage.listOfCars();
        System.out.println("Car you hired:" + hire.getCar());
    }

    public void finalizeHire(Hire hire) {
//        double totalPrice = hire.calculatePrice();
        System.out.println("Finalizing hire...");
//        System.out.println("Total price: PLN" + totalPrice);
    }

    public void carRelease() {
        System.out.println("Car has been hired. Preparing car...\n");
    }

    public String getName() {
        return name;
    }
}
