package org.liskovsubstitution.animal.after;

import org.liskovsubstitution.animal.before.Animal;

public class Cat extends BarkableAnimal {
    @Override
    public void makeNoise() {
        System.out.println("meow meow");
    }
}
