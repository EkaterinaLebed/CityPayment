package com.lea.mobilerest.repositories;

import com.lea.mobilerest.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
