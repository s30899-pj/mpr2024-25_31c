package pl.pjatk.rental_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RentalServiceApplication {
	private final RentalOffice rentalOffice;

	public RentalServiceApplication(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
		StartApplication();
	}

    public void StartApplication() {
		Car car1 = new Car("BMW", "E90", "1FTSW21R69EA38316", "Normal");
		Hire hire1= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,11,16),LocalDate.of(2024,11,23), 2000, car1);
		rentalOffice.hireCar(hire1);
		Hire hire2= new Hire(2,"Patryk","Nowak", LocalDate.of(2024,11,10),LocalDate.of(2024,11,17), 2000, car1);
		rentalOffice.hireCar(hire2);
	}

	public static void main(String[] args) {
		SpringApplication.run(RentalServiceApplication.class, args);
	}

}
