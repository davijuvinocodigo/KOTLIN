package com.livros.events.listeners

import com.livros.events.ApplicationEventBase
import com.livros.service.CompraService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class NfeActionsListener(private val compraService: CompraService) {

    @Async
    @EventListener
    fun listenerNfeActions(applicationEventBase: ApplicationEventBase) {

        println("Gerando NFE")
        val nfe = UUID.randomUUID().toString()
        val compra = applicationEventBase.compra.copy(nfe = nfe)
        compraService.atualizar(compra)
    }
}