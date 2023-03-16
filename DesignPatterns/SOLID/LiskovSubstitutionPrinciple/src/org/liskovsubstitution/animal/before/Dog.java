package org.liskovsubstitution.animal.before;

public class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("bow wow");
    }
}
