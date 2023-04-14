package com.bdg.model.to_db;

import java.util.Date;

public class Company {

    private final String name;
    private final Date foundDate;


    public Company(final String name, final Date foundDate) {
        validate(name, foundDate);
        this.name = name;
        this.foundDate = foundDate;
    }

    public String getName() {
        return name;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                ", name='" + name + '\'' +
                ", foundDate=" + foundDate +
                "}\n";
    }

    private void validate(final String name, final Date foundDate) {
        if (name == null || foundDate == null) {
            throw new NullPointerException("Passed null value: ");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Passed empty value: ");
        }
    }
}