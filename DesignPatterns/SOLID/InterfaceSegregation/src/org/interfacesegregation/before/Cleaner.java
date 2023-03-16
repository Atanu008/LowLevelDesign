package org.interfacesegregation.before;

public class Cleaner implements RestrauntEmployee{
    @Override
    public void washDishes() {
        //This is my job
    }

    @Override
    public void serveCustomers() {
        //I am not gonna do this. Not my job
    }

    @Override
    public void cookFood() {
        //I am not gonna do this. Not my job
    }
}
