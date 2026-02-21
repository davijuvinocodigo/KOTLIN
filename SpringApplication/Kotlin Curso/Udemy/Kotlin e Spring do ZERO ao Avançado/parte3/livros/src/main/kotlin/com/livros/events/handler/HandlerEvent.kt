package com.livros.events.handler

import org.springframework.context.event.EventListener
import com.livros.events.Event

// Genérica

abstract class HandleEvent<T: Event<*>> {
    abstract fun process(event: T)

    @EventListener
    fun handleEvent(event: T){
        println("👂 ${this.javaClass.simpleName} processando: ${event.type}")
        process(event)
    }
}