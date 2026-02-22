package com.livros.model.dto.resposta

import com.livros.model.enums.LivroStatus
import com.livros.modelo.Cliente
import java.math.BigDecimal

data class LivroResposta(
    var id: Int? = null,
    var nome: String,
    var valor: BigDecimal,
    var cliente: Cliente? = null,
    var status: LivroStatus? = null
)