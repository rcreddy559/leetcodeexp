package com.solid;

public class OpenClosedPrinciple {

    public static void main(String[] args) {
        PaymentProcesser paymentProcesser = new PaymentProcesser();

        PaymentMethod creditCardPayment = new CreditCardPayment();
        PaymentMethod upiPaymentMethod = new UpiPayment();
        PaymentMethod payPalPaymentMethod = new PayPalPayment();

        paymentProcesser.proccessPayment(creditCardPayment, 399.99);
        paymentProcesser.proccessPayment(upiPaymentMethod, 99.5);
        paymentProcesser.proccessPayment(payPalPaymentMethod, 299.7);
    }
}

class PaymentProcesser {
    public boolean proccessPayment(PaymentMethod paymentMethod, double amount) {
        return paymentMethod.processPayment(amount);
    }
}

class PayPalPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment for :" + amount);
        return true;
    }

    @Override
    public String paymentType() {
        return "PayPalPayment";
    }

}

class UpiPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing UPI payment for:" + amount);
        return true;
    }

    @Override
    public String paymentType() {
        return "UPI payment";
    }
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Credit card payment has been initiated for :" + amount);
        return true;
    }

    @Override
    public String paymentType() {

        return "CreditCard";
    }

}

interface PaymentMethod {
    boolean processPayment(double amount);

    String paymentType();
}
