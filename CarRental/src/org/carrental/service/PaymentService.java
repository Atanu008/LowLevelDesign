package org.carrental.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentService {

    Bill bill;

    public boolean makePayment() {
        System.out.println("Making Payment of  "+bill.calculateAmount());
        return true;
    }

}
