package org.designpatterns.behavioral.chainofresponsibility;

import java.util.Scanner;
//https://www.digitalocean.com/community/tutorials/chain-of-responsibility-design-pattern-in-java
public class ATMDispenserApplication {

    private DispenseChain dispenseChain;

    public ATMDispenserApplication(){
        this.dispenseChain = new RupeeFiveHundredDispener();

        DispenseChain twoHundredDispenser = new RupeeTwoHundredDispener();
        DispenseChain oneHundredDispenser = new RupeeOneHundredDispener();

        twoHundredDispenser.setNextChain(oneHundredDispenser);
        dispenseChain.setNextChain(twoHundredDispenser);


    }
    public static void main(String[] args) {

        ATMDispenserApplication atmDispenserApplication = new ATMDispenserApplication();

        System.out.println("Enter the Amount...");
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();

        if(amount % 100 != 0){
            System.out.println("Amount should be in multiple of 100s.");
            return;
        }

        //Please proceed with request
        atmDispenserApplication.dispenseChain.dispense(new Currency(amount));
    }
}
