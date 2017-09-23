package com.lea.mobilerest.services;

import com.lea.mobilerest.model.entities.Customer;
import com.lea.mobilerest.model.entities.Payment;
import com.lea.mobilerest.model.dto.PaymentDTO;
import com.lea.mobilerest.repositories.CustomerRepository;
import com.lea.mobilerest.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void updatePayment(Payment payment, PaymentDTO paymentDTO) {
        if (payment != null) {
            payment.setAmount(paymentDTO.getPaymentAmount());
            payment.setPaymentDateAsString(paymentDTO.getPaymentDate());
            payment.setChannel(paymentDTO.getChannel());
            Customer customer = customerRepository.findOne(paymentDTO.getCustomerId());
            if (customer != null) {
                payment.setCustomer(customer);
            }
            paymentRepository.saveAndFlush(payment);
        }
    }

    @Override
    public void deletePayment(int id) {
        paymentRepository.delete(id);
        paymentRepository.flush();
    }

    @Override
    public Payment getPayment(int id) {
        return paymentRepository.getOne(id);
    }

    @Override
    public Payment getPayment(int id, int customerID) {
        return paymentRepository.getCustomerPayment(id,customerID);
    }

    @Override
    public List<Payment> getCustomerPayments(Customer customer) {
        return paymentRepository.getCustomerPayments(customer.getId());
    }
}
