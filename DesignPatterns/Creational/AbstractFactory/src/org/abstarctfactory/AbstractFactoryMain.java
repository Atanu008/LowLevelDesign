package org.abstarctfactory;

import org.abstarctfactory.factory.AsusManufacturer;
import org.abstarctfactory.factory.Company;
import org.abstarctfactory.factory.MsiManufacturer;
import org.abstarctfactory.product.Product;

import java.util.List;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-creational-abstract-factory/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=QNpwWkdFvgQ
public class AbstractFactoryMain {
    public static void main(String[] args) {
        Company msi = new MsiManufacturer();
        Company asus = new AsusManufacturer();

        List.of(msi.createGpu(), msi.createMonitor(), asus.createGpu(), asus.createMonitor())
                .forEach(Product::assemble);

    }
}
