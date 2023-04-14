package com.bdg.model.to_db;

public class Passenger {

    private final String name;
    private final String phone;
    private final Address address;

    public Passenger(final String name,
                     final String phone,
                     final Address address) {
        validate(name, phone, address);
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                "}\n";
    }

    private void validate(final String name,
                          final String phone,
                          final Address address) {
        if (name == null || phone == null || address == null) {
            throw new NullPointerException("Passed null value: ");
        }
        if (name.isEmpty() || phone.isEmpty()) {
            throw new IllegalArgumentException("Passed empty value: ");
        }
    }
}