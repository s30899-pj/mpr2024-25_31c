package pl.pjatk.rental_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.rental_service.storage.HireStorage;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalOfficeTest {

    @Captor
    private ArgumentCaptor<Hire> hireCaptor;

    @Mock
    private HireStorage hireStorage;

    @InjectMocks
    private RentalOffice rentalOffice;

    @Test
    void shouldPassCorrectHire() {
        //GIVE
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire hire= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);
        when(hireStorage.getHireList()).thenReturn(List.of());

        //WHEN
        rentalOffice.finalizeHire(hire);

        //THEN
        verify(hireStorage).addHire(hireCaptor.capture());
        Hire capturedHire = hireCaptor.getValue();
        assertThat(capturedHire).isNotNull();
        assertThat(capturedHire).isEqualTo(hire);
    }

    @Test
    void shouldReturnTrueWhenCarIsAvailable() {
        //GIVEN
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire hire= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);
        when(hireStorage.getHireList()).thenReturn(List.of());

        //WHEN
        boolean result = rentalOffice.isCarAvailable(car.getVin(), hire.getStartDate(), hire.getEndDate());

        //THEN
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenCarIsNotAvailable() {
        //GIVEN
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire hire= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);
        Hire existingHire = new Hire(2, "Natan", "Nowak", LocalDate.of(2024, 12, 8), LocalDate.of(2024, 12, 11), car);
        when(hireStorage.getHireList()).thenReturn(List.of(hire));

        //WHEN
        boolean result = rentalOffice.isCarAvailable(car.getVin(), existingHire.getStartDate(), existingHire.getEndDate());

        //THEN
        assertThat(result).isFalse();
    }

}