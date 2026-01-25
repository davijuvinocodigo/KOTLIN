package com.livros.controller.response

import com.livros.enums.CustomerStatus

data class CustomerResponse(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)