package org.cricinfo.model.people;

import org.cricinfo.model.common.Contact;
import org.cricinfo.model.common.PersonalInfo;

public class Person {
    private String name;
    private PersonalInfo personalInfo;
    private Contact contact;

    public Person(String name) {
        this.name = name;
    }
}
