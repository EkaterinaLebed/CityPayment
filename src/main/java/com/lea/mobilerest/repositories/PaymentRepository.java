package com.lea.mobilerest.repositories;

import com.lea.mobilerest.model.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("SELECT p FROM com.lea.mobilerest.model.entities.Payment p "
            + " WHERE p.customer.id = :id")
    List<Payment> getCustomerPayments(@Param("id") int id);

    @Query("SELECT p FROM com.lea.mobilerest.model.entities.Payment p "
            + " WHERE p.customer.id = :customerId and p.id = :id")
    Payment getCustomerPayment(@Param("id") int id, @Param("customerId") int customerId);
 }