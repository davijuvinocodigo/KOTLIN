package com.livros.model.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class ClienteAtualizacaoDto(
    @field:NotEmpty(message = "Nome deve ser informado")
    var nome: String,

    @field:Email(message = "E-mail deve ser válido")
    var email: String
)