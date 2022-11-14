package com.stackoverflow.model;

import lombok.Getter;
import lombok.ToString;

@Getter
public class Bounty {

    private int reputation;
    private long expirationDate;

    public Bounty(int reputation, Long expirationDate){
        this.reputation = reputation;
        this.expirationDate = expirationDate;
    }

    public void modifyRepitation(int reputation){
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "Bounty{" +
                "reputation=" + reputation +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
