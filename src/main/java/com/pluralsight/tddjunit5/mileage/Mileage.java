package com.pluralsight.tddjunit5.mileage;

import com.pluralsight.tddjunit5.airport.Passenger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mileage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMilageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointsMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengersPointsMap() {
        return Collections.unmodifiableMap(passengersPointsMap);
    }

    public void addMilage(Passenger passenger, int miles) {

    }

    public void calculateGivenPoints() {

    }
}
