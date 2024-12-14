package pl.pjatk.rental_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.rental_service.storage.CarStorage;
import pl.pjatk.rental_service.storage.HireStorage;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RentalOfficeTest {

    @Mock
    private CarStorage carStorage;
    @Mock
    private HireStorage hireStorage;

    @InjectMocks
    private RentalOffice rentalOffice;

    @Test
    void shouldHireAdd() {
        //GIVE
        Car car1 = new Car("BMW", "E90", "1FTSW21R69EA38316", Standard.NORMAL);
        Hire hire1 = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car1);

        //WHEN
        boolean result = rentalOffice.finalizeHire(hire1);

        //THEN
        assertThat(result).isTrue();

    }

    @Test
    void carRelease() {
    }
}