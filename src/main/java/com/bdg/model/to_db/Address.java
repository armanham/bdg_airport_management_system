package com.bdg.model.to_db;

public class Address {

    private final String country;
    private final String city;

    public Address(final String country, final String city) {
        validate(country, city);
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                "}\n";
    }

    private void validate(final String country, final String city) {
        if (country == null || city == null) {
            throw new NullPointerException("Passed null value: ");
        }
        if (country.isEmpty() || city.isEmpty()) {
            throw new IllegalArgumentException("Passed empty value: ");
        }
    }
}