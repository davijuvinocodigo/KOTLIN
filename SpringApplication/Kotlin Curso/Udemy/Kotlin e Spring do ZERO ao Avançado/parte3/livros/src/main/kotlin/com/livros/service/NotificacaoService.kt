package com.livros.service

import com.livros.events.ComprarEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class NotificacaoService {

    @EventListener
    fun handlePurchaseEvent(event: ComprarEvent) {
        println("=== Serviço de Notificação ===")
        println("Recebido evento: Pedido ${event.pedidoId}")
        println("Enviando notificação para cliente ${event.clienteId}")
        println("Pedido confirmado: ${event.produtoId} x ${event.quantidade}")
        println("---")
    }
}