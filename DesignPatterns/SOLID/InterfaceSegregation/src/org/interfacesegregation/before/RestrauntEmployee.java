package org.interfacesegregation.before;

// The Interface Segregation Principle (ISP) is a design principle
// that does not recommend having methods that an interface would not use and require.
// Therefore, it goes against having fat interfaces in classes
// and prefers having small interfaces with a group of methods, each serving a particular purpose.

public interface RestrauntEmployee {
    void washDishes();
    void serveCustomers();
    void cookFood();
}
