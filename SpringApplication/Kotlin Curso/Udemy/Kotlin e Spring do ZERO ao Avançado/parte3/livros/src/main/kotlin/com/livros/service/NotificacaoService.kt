package com.livros.service

import com.livros.events.CompraRealizadaEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class NotificacaoService {

    @EventListener
    fun handlePurchaseEvent(event: CompraRealizadaEvent) {
        println("=== Servico de Notificacao ===")
        println("Recebendo evento de compra: ${event.compra.id}")
        println("---")
    }
}