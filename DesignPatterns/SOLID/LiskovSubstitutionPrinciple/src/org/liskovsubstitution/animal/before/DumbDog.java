package org.liskovsubstitution.animal.before;

class DumbDog extends Animal {
    @Override
    public void makeNoise() {
        throw new RuntimeException("I can't make noise");
    }
}
