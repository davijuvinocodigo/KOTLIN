package com.livros.events

import java.time.LocalDateTime

data class ComprarEvent(
    val pedidoId: String,
    val clienteId: String,
    val produtoId: String,
    val quantidade: Int,
    val valorTotal: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
)