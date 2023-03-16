package org.liskovsubstitution.animal.before;

public class LSBeforeMain {

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.makeNoise();
        animal = new Cat();
        animal.makeNoise();
        animal = new DumbDog();
        // wherever in our code we were using Animal class object
        // we must be able to replace it with the Dog or Cat without exploding our code.
        // What do we mean here is the child class should not implement code
        // such that if it is replaced by the parent class then the application will stop running
        animal.makeNoise(); //This will break the functionality

        //One Possible Solution Could be Animal to Bankable and NonBarkable abstract classes/interfaces
        // And Cat, Dog and DumbDog extending abstract classes accordingly
    }
}
