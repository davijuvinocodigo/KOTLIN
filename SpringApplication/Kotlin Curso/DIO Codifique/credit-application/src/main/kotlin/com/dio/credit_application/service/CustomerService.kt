package com.dio.credit_application.service

import com.dio.credit_application.entity.Customer

interface CustomerService {

    fun save(customer: Customer): Customer

    fun findById(customerId: Long): Customer

    fun delete(customerId: Long)
}