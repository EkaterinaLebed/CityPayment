package com.lea.mobilerest.model.dto;

import com.lea.mobilerest.model.entities.Payment;

public class PaymentDTO {
    private Integer customerId;
    private Float paymentAmount;
    private String paymentDate;
    private String channel;

    public PaymentDTO(Payment payment) {
        if(payment.getCustomer()!=null){
            this.customerId = payment.getCustomer().getId();
        }
        this.paymentAmount = payment.getAmount();
        this.paymentDate = payment.getPaymentDateAsString();
        this.channel = payment.getChannel();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
