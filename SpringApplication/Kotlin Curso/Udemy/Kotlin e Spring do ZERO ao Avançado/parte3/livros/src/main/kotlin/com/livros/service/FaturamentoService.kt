package com.livros.service

import com.livros.events.AuditEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service


@Service
class FaturamentoService {
    @EventListener
    fun handleComprarEvent(auditEvent: AuditEvent<*>) {
        println("=== Servico de Faturamento ===")
        println("Recebendo evento de compra: ${auditEvent.source}")
        println("---")
    }
}