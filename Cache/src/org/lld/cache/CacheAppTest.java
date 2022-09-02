package org.lld.cache;

import org.lld.cache.exceptions.NotFoundException;
import org.lld.cache.factories.CacheFactory;

public class CacheAppTest {

    public static void main(String[] args) throws NotFoundException {

        Cache<String, Student> cache = new CacheFactory().defaultCache(3);

        cache.put("1", new Student("1","Ravi"));
        cache.put("2", new Student("2","Sumit"));
        cache.put("3", new Student("3","Sushil"));
        System.out.println(cache.get("1")); // Accessing "1" here
        cache.put("4", new Student("4","Sunny")); //Evict "2" for least recently used
        System.out.println(cache.get("1"));
        cache.put("2", new Student("2","Sumit")); // Evict "3" for being least recently used
        cache.put("4", new Student("1","Ravi")); // "4" exists . just update

        System.out.println(cache.get("1"));
        System.out.println(cache.get("3"));
    }

}

class Student{
    String id;
    String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
