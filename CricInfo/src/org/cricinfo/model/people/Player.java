package org.cricinfo.model.people;

public class Player extends Person{

    private PlayerType playerType;
    private PlayerResponsibility playerResponsibility;

    public Player(String name) {
        super(name);
    }
}
