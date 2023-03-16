package org.liskovsubstitution.animal.after;

import org.liskovsubstitution.animal.before.Animal;

public class Dog extends BarkableAnimal {
    @Override
    public void makeNoise() {
        System.out.println("bow wow");
    }
}
