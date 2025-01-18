package pl.pjatk.rental_service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.rental_service.storage.HireStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@Tag("integration")
@SpringBootTest
class RentalOfficeTestIT {

    @Autowired
    private RentalOffice rentalOffice;

    @MockBean
    private HireStorage hireStorage;

    @Test
    void shouldHireCarWhenAvailable() {
        //GIVEN
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire hire = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car);
        when(hireStorage.getHireList()).thenReturn(new ArrayList<>());

        //WHEN
        rentalOffice.hireCar(hire);

        //THEN
        verify(hireStorage, times(1)).addHire(hire);
    }

    @Test
    void shouldHireCarWhenNotAvailable() {
        //GIVEN
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire existingHire = new Hire(1, "Natan", "Nowak", LocalDate.of(2024, 12, 5), LocalDate.of(2024, 12, 11), car);
        Hire hire = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car);
        List<Hire> hireList = new ArrayList<>();
        hireList.add(existingHire);
        when(hireStorage.getHireList()).thenReturn(hireList);

        //WHEN
        rentalOffice.hireCar(hire);

        verify(hireStorage, never()).addHire(hire);
    }

    @Test
    void shouldCheckCarAvailability() {
        //GIVEN
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire existingHire = new Hire(1, "Natan", "Nowak", LocalDate.of(2024, 12, 5), LocalDate.of(2024, 12, 11), car);
        List<Hire> hireList = new ArrayList<>();
        hireList.add(existingHire);
        when(hireStorage.getHireList()).thenReturn(hireList);

        //WHEN
        boolean isAvailable = rentalOffice.isCarAvailable(car.getVin(), LocalDate.of(2024, 12, 12), LocalDate.of(2024, 12, 15));
        boolean inUnavailable = rentalOffice.isCarAvailable(car.getVin(), LocalDate.of(2024, 12, 7), LocalDate.of(2024, 12, 10));

        //THEN
        assertTrue(isAvailable);
        assertFalse(inUnavailable);
    }
}