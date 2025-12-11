package com.dio.credit_application.dto

import com.dio.credit_application.entity.Address
import com.dio.credit_application.entity.Customer
import java.math.BigDecimal

data class CustomerDTO(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val income: BigDecimal,
    val password: String,
    val zipCode: String,
    val street: String
) {

    fun toEntity(): Customer {
        return Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            email = this.email,
            income = this.income,
            password = this.password,
            address = Address(
                zipCode = this.zipCode,
                street = this.street
            ),

            )
    }
}