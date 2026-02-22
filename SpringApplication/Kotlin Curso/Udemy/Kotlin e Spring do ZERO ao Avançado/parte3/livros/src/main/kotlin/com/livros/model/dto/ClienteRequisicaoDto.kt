package com.livros.model.dto

import com.livros.validation.EmailDisponivel
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class ClienteRequisicaoDto(
    @field:NotEmpty(message = "Nome deve ser informado")
    val nome: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailDisponivel(message = "E-mail já está em uso")
    val email: String
)