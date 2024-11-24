package pl.pjatk.rental_service.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.rental_service.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarStorage {
    List<Car> catalog;

    public CarStorage() {
        catalog = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        catalog.add(new Car("BMW", "E90", "1FTSW21R69EA38316", "Normal"));
        catalog.add(new Car("BMW", "E60", "3VWRF31Y96M349432", "Normal"));
        catalog.add(new Car("BMW", "E30", "2HKYF18507H502561", "Youngtimer"));
        catalog.add(new Car("BMW", "E34", "JN8AZ18U49W014005", "Youngtimer"));
        catalog.add(new Car("BMW", "F30", "WDBSK7BA8BF106986", "Premium"));
    }

    public void listOfCars() {
        System.out.println("Cars:");
        for (Car car : catalog) {
            System.out.println("- " + car);
        }
    }
}
