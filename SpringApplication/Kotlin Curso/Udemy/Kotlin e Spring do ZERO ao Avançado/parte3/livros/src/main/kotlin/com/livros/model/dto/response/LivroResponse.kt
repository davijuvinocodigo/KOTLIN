package com.livros.model.dto.response

import com.livros.model.enums.LivroStatus
import com.livros.model.Cliente
import java.math.BigDecimal

data class LivroResponse(
    var id: Int? = null,
    var nome: String,
    var valor: BigDecimal,
    var cliente: Cliente? = null,
    var status: LivroStatus? = null
)