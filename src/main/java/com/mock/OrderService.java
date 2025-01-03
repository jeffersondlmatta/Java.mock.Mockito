package com.mock;

public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public String placeOrder(double amount) {
        if (paymentService.processPayment(amount)) {
            return "Order placed successfully!";
        }
        return "Payment failed!";
    }
}
