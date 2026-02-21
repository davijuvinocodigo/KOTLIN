package com.livros.events.publisher

import com.livros.events.AuditEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

// Publicador Síncrono (Genérico)

@Component
class SynchronousPublisher<T: AuditEvent<*>>(
    publisher: ApplicationEventPublisher
): EventPublisher<T>(publisher) {
    override fun publish(event: T) {
        println("📢 [Síncrono] Publicando evento: ${event.type}")
        publisher.publishEvent(event)
    }
}