package com.livros.events.handler

import com.livros.events.AuditEvent
import org.springframework.stereotype.Component

// Ouvinte Genérico (processa qualquer evento)

@Component
class HandlerLogging : HandlerEvent<AuditEvent<*>>() {
    override fun process(event: AuditEvent<*>) {
        println("📝 LOG [${event.timestamp}] - ${event.type}: $event.id")
    }
}