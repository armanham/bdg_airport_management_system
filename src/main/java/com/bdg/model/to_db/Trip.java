package com.bdg.model.to_db;

import java.sql.Timestamp;

public class Trip {

    private final int tripNumber;
    private final Company company;
    private final String airplane;
    private final String townFrom;
    private final String townTo;
    private final Timestamp timeOut;
    private final Timestamp timeIn;

    public Trip(final int tripNumber,
                final Company company,
                final String airplane,
                final String townFrom,
                final String townTo,
                final Timestamp timeOut,
                final Timestamp timeIn) {
        validate(tripNumber, company, airplane, townFrom, townTo, timeOut, timeIn);

        this.tripNumber = tripNumber;
        this.company = company;
        this.airplane = airplane;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public Company getCompany() {
        return company;
    }

    public String getAirplane() {
        return airplane;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public Timestamp getTimeOut() {
        return timeOut;
    }

    public Timestamp getTimeIn() {
        return timeIn;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripNumber=" + tripNumber +
                ", company=" + company +
                ", airplane='" + airplane + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut=" + timeOut +
                ", timeIn=" + timeIn +
                "}\n";
    }

    private void validate(final int tripNumber,
                          final Company company,
                          final String airplane,
                          final String townFrom,
                          final String townTo,
                          final Timestamp timeOut,
                          final Timestamp timeIn) {
        if (tripNumber <= 0) {
            throw new IllegalArgumentException("'tripNumber' must be positive number: ");
        }

        if (company == null ||
                airplane == null ||
                townFrom == null ||
                townTo == null ||
                timeOut == null ||
                timeIn == null
        ) {
            throw new NullPointerException("Passed null value: ");
        }

        if (airplane.isEmpty() || townFrom.isEmpty() || townTo.isEmpty()) {
            throw new IllegalArgumentException("Passed empty value: ");
        }
    }
}