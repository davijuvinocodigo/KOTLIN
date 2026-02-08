package com.livros.service

import com.livros.events.ComprarEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service


@Service
class FaturamentoService {
    @EventListener
    fun handleComprarEvent(event: ComprarEvent) {
        println("=== Serviço de Faturamento ===")
        println("Recebido evento: Pedido ${event.pedidoId}")
        println("Gerando fatura para cliente ${event.clienteId}")
        println("Valor total: ${event.valorTotal}")
        println("---")
    }
}