package com.livros.service

import com.livros.events.CompraRealizadaEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service


@Service
class FaturamentoService {
    @EventListener
    fun handleComprarEvent(event: CompraRealizadaEvent) {
        println("=== Servico de Faturamento ===")
        println("Recebendo evento de compra: ${event.compra.id}")
        println("---")
    }
}