package com.livros.events.handler

import com.livros.events.AuditEvent
import com.livros.events.RequestLogDto
import com.livros.model.Compra
import com.livros.service.CompraService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AuditEventNfeHandler(private val compraService: CompraService) : AuditEventHandler() {

    override fun onEvent(auditEvent: AuditEvent<*>) {

        println("Gerando nfe da compra")

        val requestLogDto = auditEvent.source as RequestLogDto
        val auditEventMessage = requestLogDto.data["message"] as AuditEvent<*>
        val compra = auditEventMessage.source as Compra

        // Processar
        val compraUpdate = compra.copy(nfe = UUID.randomUUID().toString())
        compraService.atualizar(compraUpdate)

    }
}