package com.lea.mobilerest.controller;

import com.lea.mobilerest.model.entities.Customer;
import com.lea.mobilerest.model.entities.Payment;
import com.lea.mobilerest.model.dto.Assembler;
import com.lea.mobilerest.model.dto.PaymentDTO;
import com.lea.mobilerest.services.CustomerService;
import com.lea.mobilerest.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SuppressWarnings("unused")
public class AppController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET,
    headers = {"Accept=application/json"})
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable("id") int id) {
        Payment payment = paymentService.getPayment(id);

        if (payment != null) {
            return new ResponseEntity<>(Assembler.getInstance().getPaymentDTO(payment), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/payments/{customerId}/{id}", method = RequestMethod.GET,
    headers = {"Accept=application/json"})
    public ResponseEntity<PaymentDTO> getPaymentByIdCustomerId(
        @PathVariable("customerId") int customerId, @PathVariable("id") int id) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            Payment payment = paymentService.getPayment(id, customerId);
            if (payment != null) {
                return new ResponseEntity<>(Assembler.getInstance().getPaymentDTO(payment), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/paymentsall/{customerId}", method = RequestMethod.GET,
    headers = {"Accept=application/json"})
    public ResponseEntity<List<PaymentDTO>> getPaymentsList(@PathVariable("customerId") int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            List<Payment> paymentList = paymentService.getCustomerPayments(customer);
            return new ResponseEntity<>(Assembler.getInstance().getPaymentDToList(paymentList), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
