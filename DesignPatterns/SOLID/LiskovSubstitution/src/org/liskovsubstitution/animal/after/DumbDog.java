package org.liskovsubstitution.animal.after;


class DumbDog extends NonBarkableAnimal {

    @Override
    public void makeWave() {
        System.out.println("Waving...");
    }
}
