package org.interfacesegregation.before;

public class Waiter implements RestrauntEmployee{
    @Override
    public void washDishes() {
        //I am not gonna do this. Not my job
    }

    @Override
    public void serveCustomers() {
        //This is my job
    }

    @Override
    public void cookFood() {
        //I am not gonna do this. Not my job
    }
}
