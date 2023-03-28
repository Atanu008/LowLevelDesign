package org.carrental.model;

public class Location {

    private String address;

    public Location(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                '}';
    }
}
