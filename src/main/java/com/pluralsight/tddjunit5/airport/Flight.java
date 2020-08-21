package com.pluralsight.tddjunit5.airport;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Flight {

	private String id;
	Set<Passenger> passengersSet = new HashSet<Passenger>();

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengersSet() {
		return Collections.unmodifiableSet(passengersSet);
	}

	abstract boolean addPassenger( Passenger passenger );

	abstract boolean removePassenger( Passenger passenger );
}
