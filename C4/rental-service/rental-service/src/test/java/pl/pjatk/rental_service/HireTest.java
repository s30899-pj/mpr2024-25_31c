package pl.pjatk.rental_service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class HireTest {

    @Test
    void shouldCorrectCalculatePrice() {
        //GIVEN
        Car car = new Car("BMW", "E90", "VIN123", Standard.NORMAL);
        Hire hire= new Hire(1,"Jan","Kowalski", LocalDate.of(2024,12,10),LocalDate.of(2024,12,15), car);

        //WHEN
        double result = hire.calculatePrice(car);

        //THEN
        assertThat(result).isEqualTo(2000.0);
    }
}