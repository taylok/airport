package com.pluralsight.tddjunit5.mileage;

import com.pluralsight.tddjunit5.airport.Flight;
import com.pluralsight.tddjunit5.airport.Passenger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MileageTest {
    private Mileage mileage;

    @BeforeAll
    void beforeAll() {
        mileage  = new Mileage();
    }

    @ParameterizedTest
    @ValueSource(strings = { "1; e; Mike; false; 349", "2; b; John; true; 278",  "3; e; Mike; false; 319", "4; p; John; true; 817", "5; e; Mike; false; 623", "6; e; John; true; 978"})
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for (Passenger passenger: flight.getPassengersSet()) {
            mileage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void afterAll() {
        mileage.calculateGivenPoints();
        assertEquals(64, mileage.getPassengersPointsMap().get(new Passenger("Mike", false)).intValue());
        assertEquals(207, mileage.getPassengersPointsMap().get(new Passenger("John", true)).intValue());
        System.out.println(mileage.getPassengersPointsMap());
    }
}
