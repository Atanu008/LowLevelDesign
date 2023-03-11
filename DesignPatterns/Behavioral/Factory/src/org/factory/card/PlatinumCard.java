package org.factory.card;

public class PlatinumCard extends Card{
    public PlatinumCard() {
        setCreditLimit();
    }
    @Override
    public void setCreditLimit() {
        CreditLimit=500000;
    }
}
