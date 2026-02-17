package com.livros.service

import com.livros.events.AuditEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class EstoqueService {

    @EventListener
    fun handlePurchaseEvent(auditEvent: AuditEvent<*>) {
        println("=== Servico de Estoque ===")
        println("Recebendo evento de compra: ${auditEvent.source}")
        println("---")
    }
}