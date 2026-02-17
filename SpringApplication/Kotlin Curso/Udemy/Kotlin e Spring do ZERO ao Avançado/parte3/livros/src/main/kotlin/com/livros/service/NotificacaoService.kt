package com.livros.service

import com.livros.events.AuditEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class NotificacaoService {

    @EventListener
    fun handlePurchaseEvent(auditEvent: AuditEvent<*>) {
        println("=== Servico de Notificacao ===")
        println("Recebendo evento de compra: ${auditEvent.source}")
        println("---")
    }
}