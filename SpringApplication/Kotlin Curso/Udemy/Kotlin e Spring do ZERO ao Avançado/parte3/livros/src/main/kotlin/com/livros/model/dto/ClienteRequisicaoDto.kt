package com.livros.model.dto

import com.livros.validacao.EmailDisponivel
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class ClienteRequisicaoDto(
    @field:NotEmpty(message = "Nome deve ser informado")
    var nome: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailDisponivel(message = "E-mail já está em uso")
    var email: String
)