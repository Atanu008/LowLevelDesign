package org.factory.card;

public abstract class Card {
    protected double CreditLimit;
    public abstract void setCreditLimit();
    @Override
    public String toString(){
        return "Your card is "+this.getClass().getSimpleName()+" & your credit limit is "+CreditLimit;
    }
}
