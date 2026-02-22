package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

// Publicador Síncrono (Genérico)

@Component
class PublisherSynchronous<T: AuditoriaEvento<*>>(
    publisher: ApplicationEventPublisher
): PublicadorEvento<T>(publisher) {
    override fun publish(event: T) {
        println("📢 [Síncrono] Publicando evento: ${event.type}")
        publisher.publishEvent(event)
    }
}