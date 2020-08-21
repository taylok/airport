package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
        }

        @Test
        public void testEconomyFlightUsualPassenger() {
            Passenger mike = new Passenger("Mike", false);

            assertEquals("1", economyFlight.getId());
            assertEquals(true, economyFlight.addPassenger(mike));
            assertEquals(1, economyFlight.getPassengersList().size());
            assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());

            assertEquals(true, economyFlight.removePassenger(mike));
            assertEquals(0, economyFlight.getPassengersList().size());
        }

        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger john = new Passenger("John", true);

            assertEquals("1", economyFlight.getId());
            assertEquals(true, economyFlight.addPassenger(john));
            assertEquals(1, economyFlight.getPassengersList().size());
            assertEquals("John", economyFlight.getPassengersList().get(0).getName());

            assertEquals(false, economyFlight.removePassenger(john));
            assertEquals(1, economyFlight.getPassengersList().size());
        }

    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
        }

        @Test
        public void testBusinessFlightUsualPassenger() {
            Passenger mike = new Passenger("Mike", false);

            assertEquals(false, businessFlight.addPassenger(mike));
            assertEquals(0, businessFlight.getPassengersList().size());
            assertEquals(false, businessFlight.removePassenger(mike));
            assertEquals(0, businessFlight.getPassengersList().size());

        }

        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger john = new Passenger("John", true);

            assertEquals(true, businessFlight.addPassenger(john));
            assertEquals(1, businessFlight.getPassengersList().size());
            assertEquals(false, businessFlight.removePassenger(john));
            assertEquals(1, businessFlight.getPassengersList().size());

        }

    }

}
