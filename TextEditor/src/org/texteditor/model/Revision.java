package org.texteditor.model;

import lombok.Getter;
import lombok.Setter;

//Storing last action performed with characterNode
@Getter
@Setter
public class Revision {

    Action action;
    CharacterNode characterNode;

    public Revision(Action action, CharacterNode characterNode) {
        this.action = action;
        this.characterNode = characterNode;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "action=" + action +
                ", characterNode=" + characterNode +
                '}';
    }
}
