package org.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance("Geekific"));
        Singleton singleton = Singleton.getInstance("Singleton"); // This is not getting initialized
        System.out.println(singleton); // Geeting same instance of Geekific
        System.out.println(singleton.getData());
    }
}
