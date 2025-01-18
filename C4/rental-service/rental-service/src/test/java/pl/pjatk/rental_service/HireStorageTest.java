package pl.pjatk.rental_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.pjatk.rental_service.storage.HireStorage;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Tag("unit")
class HireStorageTest {
    private HireStorage hireStorage;

    @BeforeEach
    void setup() {
        this.hireStorage = new HireStorage();
    }

    @Test
    void returnCorrectListOfHires() {
        //GIVEN
        Car car1 = new Car("BMW", "E90", "1FTSW21R69EA38316", Standard.NORMAL);
        Car car2 = new Car("BMW", "E60", "3VWRF31Y96M349432", Standard.NORMAL);
        Hire hire1 = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car1);
        Hire hire2 = new Hire(2, "Natan", "Nowak", LocalDate.of(2024, 12, 8), LocalDate.of(2024, 12, 11), car2);

        hireStorage.addHire(hire1);
        hireStorage.addHire(hire2);

        //WHEN
        List<Hire> hireList = hireStorage.getHireList();

        //THEN
        assertThat(hireList).containsExactly(hire1, hire2);
    }

    @Test
    void shouldNotContainHireNotAdded() {
        // GIVEN
        Car car1 = new Car("BMW", "E90", "1FTSW21R69EA38316", Standard.NORMAL);
        Car car2 = new Car("BMW", "E60", "3VWRF31Y96M349432", Standard.NORMAL);
        Hire hire1 = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car1);
        Hire hire2 = new Hire(2, "Natan", "Nowak", LocalDate.of(2024, 12, 8), LocalDate.of(2024, 12, 11), car2);

        hireStorage.addHire(hire1);

        // WHEN
        List<Hire> hires = hireStorage.getHireList();

        // THEN
        assertThat(hires).doesNotContain(hire2);
    }

    @Test
    void shouldAllowAddingTheSameHireMultipleTimes() {
        // GIVEN
        Car car = new Car("BMW", "X5", "VIN123", Standard.NORMAL);
        Hire hire = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car);
        hireStorage.addHire(hire);
        hireStorage.addHire(hire);

        // WHEN
        List<Hire> hireList = hireStorage.getHireList();

        // THEN
        assertThat(hireList).containsExactly(hire, hire);
    }

    @Test
    void shouldAddHireToList() {
        // GIVEN
        Car car = new Car("BMW", "E90", "1FTSW21R69EA38316", Standard.NORMAL);
        Hire hire = new Hire(1, "Jan", "Kowalski", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 15), car);

        // WHEN
        hireStorage.addHire(hire);

        // THEN
        assertThat(hireStorage.getHireList()).contains(hire);
    }
}