package org.abstarctfactory.factory;

import org.abstarctfactory.product.Gpu;
import org.abstarctfactory.product.Monitor;

//This is abstract Factory
public abstract class Company {

    public abstract Gpu createGpu();
    public abstract Monitor createMonitor();
}
