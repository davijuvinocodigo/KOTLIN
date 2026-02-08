package com.livros.events.actions

import com.livros.events.CompraRealizadaEvent
import com.livros.service.LivroService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class AtualizaStatusActions(private val livroService: LivroService) {

    @Async
    @EventListener
    fun listenerStatusActions(compraRealizadaEvent: CompraRealizadaEvent) {

        println("Atualizando status dos livros")
        livroService.comprar(compraRealizadaEvent.compra.livros)
    }
}