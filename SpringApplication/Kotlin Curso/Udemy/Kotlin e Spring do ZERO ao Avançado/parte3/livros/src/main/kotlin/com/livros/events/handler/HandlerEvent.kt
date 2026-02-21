package com.livros.events.handler

import org.springframework.context.event.EventListener
import com.livros.events.AuditEvent

// Genérica

abstract class HandlerEvent<T: AuditEvent<*>> {
    abstract fun process(event: T)

    @EventListener
    fun handleEvent(event: T){
        println("👂 ${this.javaClass.simpleName} processando: ${event.type}")
        process(event)
    }
}