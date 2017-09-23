package com.lea.mobilerest.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages ={"com.lea.mobilerest.repositories"})
@EntityScan(basePackages = {"com.lea.mobilerest.model.entities"})
@EnableTransactionManagement
public class RepositoryConfig {

}
