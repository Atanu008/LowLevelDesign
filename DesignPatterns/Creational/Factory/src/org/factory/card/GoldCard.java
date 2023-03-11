package org.factory.card;

public class GoldCard extends Card{
    public GoldCard() {
        setCreditLimit();
    }
    @Override
    public void setCreditLimit() {
        CreditLimit=250000;
    }
}