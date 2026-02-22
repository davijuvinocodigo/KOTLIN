package com.livros.model.dto

import com.livros.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class ClienteRequestDto (
    @field:NotEmpty(message = "Nome deve ser informado")
    var nome: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailAvailable(message = "Email em uso")
    var email: String
)