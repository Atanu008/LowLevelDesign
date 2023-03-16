package org.dependencyinversion.before;

public class MacMain {
    public static void main(String[] args) {
        //here we dont have to provide implementation of Keyboard/Monitor
        //They are tightly coupled and will be Created as a part of Macintosh object creation
        //This will violate Dependency Inversion principle
        Macintosh macintosh = new Macintosh();
    }
}
