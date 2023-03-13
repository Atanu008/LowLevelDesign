package org.singleton;

//https://www.educative.io/courses/software-design-patterns-best-practices/B8nMkqBWONo
//https://github.com/geekific-official/geekific-youtube/tree/main/pattern-creational-singleton/src/main/java/com/youtube/geekific

//The above solution marks the singleton instance volatile however the JVM volatile implementation for Java versions 1.4 will not work correctly for double checked locking and you'll need to use another way to create your singletons.
//
//The double checked locking is now considered an antipattern and its utility has largely passed away as JVM startup times have sped up over the years.
// Double checked Locking : https://stackoverflow.com/questions/1625118/java-double-checked-locking

public class Singleton {


    private volatile static Singleton onlyInstance;
    private final String data;

    public String getData() {
        return data;
    }

    // Make the constructor private so its only accessible to
    // members of the class.
    private Singleton(String data){
        this.data = data;
    }

    // Create a static method for object creation
    public static Singleton getInstance(String data){
        // Only instantiate the object when needed.
        if(onlyInstance == null){
            // Note how we are synchronizing on the class object
            //So no other Thread ca not create object on this class
            synchronized (Singleton.class){
                if(onlyInstance == null){
                    onlyInstance = new Singleton(data);
                }
            }
        }
        return onlyInstance;
    }
}
