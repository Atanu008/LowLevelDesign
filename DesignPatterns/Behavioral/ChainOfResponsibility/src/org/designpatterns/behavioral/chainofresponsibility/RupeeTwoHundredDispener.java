package org.designpatterns.behavioral.chainofresponsibility;


public class RupeeTwoHundredDispener implements DispenseChain{

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 200){

            int numberOfTwoHundredNotes = currency.getAmount() / 200;
            int remainingAmount = currency.getAmount() % 200;

            System.out.println("Dispensing "+numberOfTwoHundredNotes +" 200 Rupee Notes");

            if(remainingAmount > 0){
                this.nextChain.dispense(new Currency(remainingAmount));
            }
        }
        else{
            this.nextChain.dispense(currency);
        }
    }
}
