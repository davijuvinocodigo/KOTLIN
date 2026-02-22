package com.livros.model.dto.response

import com.livros.model.enums.ClienteStatus

data class ClienteResposta(
    var id: Int? = null,
    var nome: String,
    var email: String,
    var status: ClienteStatus
)