package com.livros.model.dto

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class CompraRequisicaoDto(
    @field:NotNull
    @field:Positive
    @JsonAlias("cliente_id")
    val clienteId: Int,

    @field:NotNull
    @JsonAlias("livro_ids")
    val livroIds: Set<Int>
)