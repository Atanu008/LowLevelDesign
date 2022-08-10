package org.designpatterns.behavioral.strategy;

import java.util.Date;

//https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial
public class PaymentApplication {

    public static void main(String[] args) {

        Item itemA = new Item("A", 100);
        Item itemB = new Item("B", 200);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(itemA);
        shoppingCart.addItem(itemB);

        PaymentStrategy paymentStrategy = new PayPalStrategy("ParthaArpita", "apa");
        PaymentService paymentService = new PaymentService(paymentStrategy);

        shoppingCart.setPaymentService(paymentService);

        shoppingCart.pay();

        //Credit Card Payment
        Item itemC = new Item("C", 500);
        shoppingCart.addItem(itemC);
        PaymentStrategy creditCardpaymentStrategy = new CreditCardStrategy("Atanu", 7770808, 908, new Date());
        paymentService.setPaymentStrategy(creditCardpaymentStrategy);

        shoppingCart.pay();

    }
}
