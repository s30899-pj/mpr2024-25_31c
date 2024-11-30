package pl.pjatk.rental_service.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.rental_service.Car;
import pl.pjatk.rental_service.Standard;

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
        catalog.add(new Car("BMW", "E90", "1FTSW21R69EA38316", Standard.NORMAL));
        catalog.add(new Car("BMW", "E60", "3VWRF31Y96M349432", Standard.NORMAL));
        catalog.add(new Car("BMW", "E30", "2HKYF18507H502561", Standard.YOUNGTIMER));
        catalog.add(new Car("BMW", "E34", "JN8AZ18U49W014005", Standard.YOUNGTIMER));
        catalog.add(new Car("BMW", "F30", "WDBSK7BA8BF106986", Standard.PREMIUM));
    }

    public void listOfCars() {
        System.out.println("Cars:");
        for (Car car : catalog) {
            System.out.println("- " + car);
        }
    }
}
