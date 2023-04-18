package com.bdg.db_repository;

import com.bdg.model.Passenger;
import com.bdg.model.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerRepository {

    Passenger getBy(int id);

    Set<Passenger> getAll();

    Set<Passenger> get(int offset, int perPage, String sort);

    Passenger save(Passenger passenger);

    Passenger updateBy(int id, Passenger passenger);

    void deleteBy(int id);

    List<Passenger> getPassengersOfTrip(int tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(int passengerId, int tripNumber);
}