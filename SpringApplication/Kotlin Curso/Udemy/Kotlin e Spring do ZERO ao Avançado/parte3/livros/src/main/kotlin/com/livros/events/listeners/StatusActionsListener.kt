package com.livros.events.listeners

import com.livros.events.ApplicationEventBase
import com.livros.service.LivroService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class StatusActionsListener(private val livroService: LivroService) {

    @Async
    @EventListener
    fun listenerStatusActions(applicationEventBase: ApplicationEventBase) {

        println("Atualizando status dos livros")
        livroService.compra(applicationEventBase.compra.livros)
    }
}