package com.dio.credit_application.service

import com.dio.credit_application.entity.Credit
import java.util.UUID

interface CreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}