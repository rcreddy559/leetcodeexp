package com.solid;

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        // Flexible configuration using different implementations
        PaymentProvider creditCardPayment = new CreditCardPayment();
        PaymentLogger fileLogger = new FilePaymentLogger();

        PaymentService paymentService = new PaymentService(creditCardPayment, fileLogger);
        paymentService.processTransaction(500.00);

        // Easy to switch implementations without changing core logic
        PaymentProvider payPalPayment = new PayPalPayment();
        PaymentLogger databaseLogger = new DatabasePaymentLogger();

        PaymentService alternatePaymentService = new PaymentService(payPalPayment, databaseLogger);
        alternatePaymentService.processTransaction(250.75);
    }
}

interface PaymentProvider {
    boolean processPayment(double amount);
}

interface PaymentLogger {
    void logTransaction(double amount, boolean status);
}

class CreditCardPayment implements PaymentProvider {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        return true;
    }
}

class PayPalPayment implements PaymentProvider {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        return true;
    }
}

class FilePaymentLogger implements PaymentLogger {
    @Override
    public void logTransaction(double amount, boolean status) {
        System.out.println("Logging transaction: $" + amount + " Status: " + status);
    }
}

class DatabasePaymentLogger implements PaymentLogger {
    @Override
    public void logTransaction(double amount, boolean status) {
        System.out.println("Database logging transaction: $" + amount + " Status: " + status);
    }
}

class PaymentService {
    private final PaymentProvider paymentProvider;
    private final PaymentLogger paymentLogger;

    // Constructor Dependency Injection
    public PaymentService(PaymentProvider paymentProvider, PaymentLogger paymentLogger) {
        this.paymentProvider = paymentProvider;
        this.paymentLogger = paymentLogger;
    }

    public void processTransaction(double amount) {
        boolean transactionStatus = paymentProvider.processPayment(amount);
        paymentLogger.logTransaction(amount, transactionStatus);
    }
}
