package org.factory.card;

public class SilverCard extends Card{
    public SilverCard() {
        setCreditLimit();
    }
    @Override
    public void setCreditLimit() {
        CreditLimit=100000;
    }
}
