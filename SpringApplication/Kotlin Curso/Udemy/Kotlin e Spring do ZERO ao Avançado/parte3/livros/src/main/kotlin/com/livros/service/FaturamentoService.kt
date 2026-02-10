package com.livros.service

import com.livros.events.CompraRealizadaEventDto
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service


@Service
class FaturamentoService {
    @EventListener
    fun handleComprarEvent(event: CompraRealizadaEventDto) {
        println("=== Servico de Faturamento ===")
        println("Recebendo evento de compra: ${event.compra.id}")
        println("---")
    }
}