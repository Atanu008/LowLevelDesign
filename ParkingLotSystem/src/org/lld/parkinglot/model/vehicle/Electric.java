package org.lld.parkinglot.model.vehicle;

public class Electric extends Vehicle{

    public Electric(String licenseNumber){
        super(licenseNumber, VehicleType.ELECTRIC);
    }
}
