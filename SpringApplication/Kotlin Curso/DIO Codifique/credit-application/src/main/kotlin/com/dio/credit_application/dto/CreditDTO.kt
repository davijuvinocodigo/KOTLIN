package com.dio.credit_application.dto

import com.dio.credit_application.entity.Credit
import com.dio.credit_application.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {

    fun toEntity(): Credit {
        return Credit(
            creditValue = this.creditValue,
            dayFirstInstallment = this.dayFirstInstallment,
            numberOfInstallment = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
        )
    }
}
