package com.dio.credit_application.service.impl

import com.dio.credit_application.entity.Customer
import com.dio.credit_application.repository.CustomerRepository
import com.dio.credit_application.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): CustomerService {

    override fun save(customer: Customer): Customer {
       return this.customerRepository.save(customer)
    }

    override fun findById(customerId: Long): Customer {
        return this.customerRepository.findById(customerId).orElseThrow {
            throw RuntimeException("Customer with id $customerId not found")
        }
    }

    override fun delete(customerId: Long) {
        val customer = this.findById(customerId)
        this.customerRepository.delete(customer)
    }
}