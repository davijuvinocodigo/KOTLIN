package com.livros.model.dto

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class LivroRequestDto (

    @field:NotEmpty(message = "Nome deve ser informado")
    var nome: String,

    @field:NotNull(message = "Price deve ser informado")
    var valor: BigDecimal,

    @JsonAlias("cliente_id")
    var clienteId: Int
)