package com.livros.model.dto

import java.math.BigDecimal

data class LivroRequestAtualizaDto(
    var name: String?,
    var price: BigDecimal?
)
