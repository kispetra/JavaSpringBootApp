package com.example.task1.Client;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="client")

public class Client {

    private String firstName;
    private String lastName;
    private long oib;
    private String city;
    private String street;
    private long zipCode;
    private String country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getOib() {
        return oib;
    }

    public void setOib(long oib) {
        this.oib = oib;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
