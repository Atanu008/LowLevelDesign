package org.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items;
    PaymentService paymentService;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public int calculateTotal(){
        int totalPrice = 0;
        for(Item item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    public void pay(){
        int totalAmount = calculateTotal();
        paymentService.pay(totalAmount);
    }
}
