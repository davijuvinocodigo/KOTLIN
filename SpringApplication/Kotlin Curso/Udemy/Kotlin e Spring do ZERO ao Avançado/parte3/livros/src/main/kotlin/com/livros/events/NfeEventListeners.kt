package com.livros.events

import com.livros.service.CompraService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class NfeEventListeners(private val compraService: CompraService) {

    //@Async
    //@EventListener
    fun listenerNfeActions(auditEvent: AuditEvent<*>) {

        //println("Gerando NFE")
        val nfe = UUID.randomUUID().toString()
        //val compra = event.compra.copy(nfe = nfe)
        //compraService.atualizar(compra)
    }
}