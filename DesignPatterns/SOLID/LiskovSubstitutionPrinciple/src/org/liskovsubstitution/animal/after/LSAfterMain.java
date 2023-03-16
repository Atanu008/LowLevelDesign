package org.liskovsubstitution.animal.after;

public class LSAfterMain {
    public static void main(String[] args) {
        BarkableAnimal animal = new Dog();
        animal.makeNoise();
        animal = new Cat();
        animal.makeNoise();
        NonBarkableAnimal nonAnimal = new DumbDog();
        nonAnimal.makeWave();
    }
}
