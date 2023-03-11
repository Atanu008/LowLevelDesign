package org.abstarctfactory.factory;


import org.abstarctfactory.product.AsusGpu;
import org.abstarctfactory.product.AsusMonitor;
import org.abstarctfactory.product.Gpu;
import org.abstarctfactory.product.Monitor;

//This is one of the Concrete Implementation of abstract factory
//Which is responsible for creating different Type of object(Particular type(in this case Asus) of an object)

public class AsusManufacturer extends Company{
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
