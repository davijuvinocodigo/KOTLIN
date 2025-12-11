package com.dio.credit_application.service.impl

import com.dio.credit_application.entity.Credit
import com.dio.credit_application.repository.CreditRepository
import com.dio.credit_application.service.CreditService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): CreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode) ?:
            throw RuntimeException("Credit code $creditCode not found")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact administator")
    }
}