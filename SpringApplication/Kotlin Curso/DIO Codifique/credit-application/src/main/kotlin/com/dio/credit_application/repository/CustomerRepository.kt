package com.dio.credit_application.repository

import com.dio.credit_application.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long>