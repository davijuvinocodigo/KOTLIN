package com.livros.service

import com.livros.events.ComprarEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class EstoqueService {

    @EventListener
    fun handlePurchaseEvent(event: ComprarEvent) {
        println("=== Serviço de Estoque ===")
        println("Recebido evento: Pedido ${event.pedidoId}")
        println("Atualizando estoque do produto ${event.produtoId}")
        println("Quantidade vendida: ${event.quantidade}")
        println("---")
    }
}