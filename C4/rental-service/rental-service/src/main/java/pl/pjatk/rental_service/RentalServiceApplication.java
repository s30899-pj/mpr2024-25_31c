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
		Car car1 = new Car("BMW", "E90", "1FTSW21R69EA38316", Standard.NORMAL);
//		Hire hire1= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,12,1),LocalDate.of(2024,12,3), 2000, car1);
//		rentalOffice.hireCar(hire1);
//		Hire hire2= new Hire(2,"Natan","Nowak", LocalDate.of(2024,12,5),LocalDate.of(2024,12,10), 2000, car1);
//		rentalOffice.hireCar(hire2);
//		Hire hire3= new Hire(2,"Igor","Tartak", LocalDate.of(2024,12,10),LocalDate.of(2024,12,20), 2000, car1);
//		rentalOffice.hireCar(hire3);
//		Hire hire4= new Hire(2,"Radek","Nowacki", LocalDate.of(2024,12,22),LocalDate.of(2024,12,25), 2000, car1);
//		rentalOffice.hireCar(hire4);
		Hire hire1= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car1);
		rentalOffice.hireCar(hire1);
		Hire hire2= new Hire(2,"Natan","Nowak", LocalDate.of(2024,12,8),LocalDate.of(2024,12,11), car1);
		rentalOffice.hireCar(hire2);
		Hire hire3= new Hire(2,"Igor","Tartak", LocalDate.of(2024,12,14),LocalDate.of(2024,12,17), car1);
		rentalOffice.hireCar(hire3);
		Hire hire4= new Hire(2,"Radek","Nowacki", LocalDate.of(2024,12,12),LocalDate.of(2024,12,14),car1);
		rentalOffice.hireCar(hire4);
		Hire hire5= new Hire(2,"Tadeusz","Baryka", LocalDate.of(2024,12,5),LocalDate.of(2024,12,20), car1);
		rentalOffice.hireCar(hire5);
	}

	public static void main(String[] args) {
		SpringApplication.run(RentalServiceApplication.class, args);
	}

}
