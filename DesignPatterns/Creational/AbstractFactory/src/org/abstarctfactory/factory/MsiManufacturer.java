package org.abstarctfactory.factory;

import org.abstarctfactory.product.Gpu;
import org.abstarctfactory.product.Monitor;
import org.abstarctfactory.product.MsiGpu;
import org.abstarctfactory.product.MsiMonitor;

//This is one of the Concrete Implementation of abstract factory
//Which is responsible for creating different Type of object(Particular type(in this case Msi) of an object)
public class MsiManufacturer extends Company{
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}
