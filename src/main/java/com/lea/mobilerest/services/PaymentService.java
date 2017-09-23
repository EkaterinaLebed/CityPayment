package com.lea.mobilerest.services;

import com.lea.mobilerest.model.entities.Customer;
import com.lea.mobilerest.model.entities.Payment;
import com.lea.mobilerest.model.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
//    void addPayment(Payment payment);
//    Integer makePayment(Customer customer, PaymentDTO payment);
    Payment getPayment(int id);
    Payment getPayment(int id, int customerID);
//    List<Payment> getAllPayments();
    List<Payment> getCustomerPayments(Customer customer);
//    Integer create(PaymentDTO resource);
    void updatePayment(Payment payment,PaymentDTO paymentDTO);
    void deletePayment(int id);
}
