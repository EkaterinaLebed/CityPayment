package com.lea.mobilerest.model.dto;

import com.lea.mobilerest.model.entities.Payment;

import java.util.ArrayList;
import java.util.List;

public class Assembler {
    private static Assembler instance;

    public List<PaymentDTO> getPaymentDToList(List<Payment> paymentList) {
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        for (Payment payment : paymentList) {
            paymentDTOList.add(new PaymentDTO(payment));
        }
        return paymentDTOList;
    }

    public PaymentDTO getPaymentDTO(Payment payment) {
        return new PaymentDTO(payment);
    }

    public static Assembler getInstance() {
        if(instance==null) instance=new Assembler();
        return instance;
    }
}
