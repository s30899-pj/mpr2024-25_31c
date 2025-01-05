package pl.pjatk.rental_service;

import org.springframework.stereotype.Component;
import pl.pjatk.rental_service.storage.HireStorage;

import java.time.LocalDate;

@Component
public class RentalOffice {
    //    private final CarStorage carStorage;
    private final HireStorage hireStorage;
    private final String name = "Car NET";

    public RentalOffice(HireStorage hireStorage) {
//        this.carStorage = carStorage;
        this.hireStorage = hireStorage;
    }

    public void hireCar(Hire hire) {
//        welcome();
//        chooseCar(hire);
        if (finalizeHire(hire)) {
            carRelease(hire);
        } else {
            System.out.println("Car hire could not be completed.\n");
        }
    }
//
//    public void welcome() {
////        System.out.println("Welcome to " + getName() + "!");
////        System.out.println("We are here to help you find the perfect car for your needs.");
//    }

//    public void chooseCar(Hire hire) {
////        System.out.println("Choose the car you want to hire:");
////        carStorage.listOfCars();
////        System.out.println("Car you selected: " + hire.getCar());
//    }

    public boolean finalizeHire(Hire hire) {
//        System.out.println("Checking car availability...");
        if (isCarAvailable(hire.getCar().getVin(), hire.getStartDate(), hire.getEndDate())) {
//            System.out.println("Car is available! Finalizing hire...");
            hireStorage.addHire(hire);
            double totalPrice = hire.calculatePrice(hire.getCar());
//            System.out.println("Total price for hire: PLN " + totalPrice);
            return true;
        } else {
//            System.out.println("Sorry, the car is not available for the selected dates.");
            return false;
        }
    }

    public void carRelease(Hire hire) {
        System.out.println("Car hire completed successfully!\n");
//        System.out.println("Car is being prepared for: " + hire.getFirstName() + " " + hire.getLastName());
//        System.out.println("Details of the " + hire);
    }

    public boolean isCarAvailable(String vin, LocalDate startDate, LocalDate endDate) {
        return hireStorage.getHireList().stream().noneMatch(hire ->
                hire.getCar().getVin().equals(vin) &&
                        (startDate.isBefore(hire.getEndDate()) && endDate.isAfter(hire.getStartDate()))
        );
    }

    public String getName() {
        return name;
    }

}