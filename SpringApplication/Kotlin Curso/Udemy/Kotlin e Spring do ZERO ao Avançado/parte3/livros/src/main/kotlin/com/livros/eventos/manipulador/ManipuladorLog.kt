package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaEvento
import org.springframework.stereotype.Component

// Ouvinte Genérico (processa qualquer evento)

@Component
class HandlerLogging : ManipuladorEvento<AuditoriaEvento<*>>() {
    override fun process(event: AuditoriaEvento<*>) {
        println("📝 LOG [${event.timestamp}] - ${event.type}: $event.id")
    }
}