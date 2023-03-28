package org.carrental.model;

import lombok.Getter;

@Getter
public abstract class Person {
    private String name;
    private String address;
    private String email;
    private int phoneNumber;

    public Person(String name, String address, String email, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
