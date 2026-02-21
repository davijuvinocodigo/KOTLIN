package com.livros.events.publisher

import com.livros.events.AuditEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

// Publicador Assíncrono (Genérico)

@Component
class PublisherAsynchronous<T: AuditEvent<*>>(
    publisher: ApplicationEventPublisher
): PublisherEvent<T>(publisher) {
    override fun publish(event: T) {
        Thread{
            Thread.sleep(1000)
            println("🔄 [Assíncrono] Publicando evento: ${event.type}")
            publisher.publishEvent(event)
        }.start()
    }
}