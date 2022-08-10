package org.designpatterns.behavioral.chainofresponsibility;

public class RupeeOneHundredDispener implements DispenseChain{

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 100){

            int numberOfOneHundredNotes = currency.getAmount() / 100;
            int remainingAmount = currency.getAmount() % 100;

            System.out.println("Dispensing "+numberOfOneHundredNotes +" 100 Rupee Notes");

            if(remainingAmount > 0){
                this.nextChain.dispense(new Currency(remainingAmount));
            }
        }
        else{
            this.nextChain.dispense(currency);
        }
    }
}
