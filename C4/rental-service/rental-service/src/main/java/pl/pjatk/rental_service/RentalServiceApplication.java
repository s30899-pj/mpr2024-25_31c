package pl.pjatk.rental_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjatk.rental_service.storage.HireStorage;

@SpringBootApplication
public class RentalServiceApplication {
	private final RentalOffice rentalOffice;
	private final HireStorage hireStorage;

	public RentalServiceApplication(RentalOffice rentalOffice, HireStorage hireStorage) {
        this.rentalOffice = rentalOffice;
        this.hireStorage = hireStorage;
	}

    public void StartApplication() {
		Car car1 = new Car("BMW", "E90", "1FTSW21R69EA38316", "Normal");
		rentalOffice.hireCar(new Hire(1,"Jan","Kowalski", 2024-11-16,2024-11-23, 2000, car1));
	}

	public static void main(String[] args) {
		SpringApplication.run(RentalServiceApplication.class, args);
	}

}
