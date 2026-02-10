package com.livros.events

import com.livros.service.LivroService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class StatusEventListeners(private val livroService: LivroService) {

    @Async
    @EventListener
    fun listenerStatusActions(event: CompraRealizadaEventDto) {

        println("Atualizando status dos livros")
        livroService.comprar(event.compra.livros)
    }
}