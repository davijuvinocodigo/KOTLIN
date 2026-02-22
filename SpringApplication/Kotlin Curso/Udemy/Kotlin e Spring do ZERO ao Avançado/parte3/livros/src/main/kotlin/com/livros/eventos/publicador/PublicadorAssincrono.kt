package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

// Publicador Assíncrono (Genérico)

@Component
class PublisherAsynchronous<T: AuditoriaEvento<*>>(
    publisher: ApplicationEventPublisher
): PublicadorEvento<T>(publisher) {
    override fun publish(event: T) {
        Thread{
            Thread.sleep(1000)
            println("🔄 [Assíncrono] Publicando evento: ${event.type}")
            publisher.publishEvent(event)
        }.start()
    }
}