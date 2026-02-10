package com.livros.service

import com.livros.events.CompraRealizadaEventDto
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class NotificacaoService {

    @EventListener
    fun handlePurchaseEvent(event: CompraRealizadaEventDto) {
        println("=== Servico de Notificacao ===")
        println("Recebendo evento de compra: ${event.compra.id}")
        println("---")
    }
}