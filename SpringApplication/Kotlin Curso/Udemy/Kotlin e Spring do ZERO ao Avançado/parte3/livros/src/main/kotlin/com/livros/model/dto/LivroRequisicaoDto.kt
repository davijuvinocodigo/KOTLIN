package com.livros.model.dto

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class LivroRequisicaoDto(
    @field:NotEmpty(message = "Nome deve ser informado")
    val nome: String,

    @field:NotNull(message = "Valor deve ser informado")
    val valor: BigDecimal,

    @JsonAlias("cliente_id")
    val clienteId: Int
)