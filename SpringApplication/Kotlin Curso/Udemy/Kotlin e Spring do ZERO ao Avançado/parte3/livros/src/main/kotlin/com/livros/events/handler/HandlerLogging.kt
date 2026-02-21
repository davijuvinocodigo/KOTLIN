package com.livros.events.handler

import com.livros.events.Event
import org.springframework.stereotype.Component

// Ouvinte Genérico (processa qualquer evento)

@Component
class EventLoggingHandler : HandleEvent<Event<*>>() {
    override fun process(event: Event<*>) {
        println("📝 LOG [${event.timestamp}] - ${event.type}: $event.id")
    }
}