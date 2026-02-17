package com.livros.events.handler

import com.livros.events.AuditEvent
import com.livros.events.RequestLogDto
import com.livros.model.Compra
import com.livros.service.LivroService
import org.springframework.stereotype.Component

@Component
class AuditEventStatusHandler(private val livroService: LivroService) : AuditEventHandler() {
    override fun onEvent(auditEvent: AuditEvent<*>) {
        println("Atualizando status dos livros")

        val requestLogDto = auditEvent.source as RequestLogDto
        val auditEventMessage = requestLogDto.data["message"] as AuditEvent<*>
        val compra = auditEventMessage.source as Compra

        // Atualizar o status dos livros para "COMPRADO"
        livroService.comprar(compra.livros)


    }
}