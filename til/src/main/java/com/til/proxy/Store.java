package com.til.proxy;

public class Store {

    Payment payment;

    public Store(Payment payment) {
        this.payment = payment;
    }
    public void buySonmething(int amount) {
        payment.pay(amount);

    }
}
