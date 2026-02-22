package com.livros.eventos.manipulador

import org.springframework.context.event.EventListener
import com.livros.eventos.AuditoriaEvento

// Genérica

abstract class HandlerEvent<T: AuditoriaEvento<*>> {
    abstract fun process(event: T)

    @EventListener
    fun handleEvent(event: T){
        println("👂 ${this.javaClass.simpleName} processando: ${event.type}")
        process(event)
    }
}