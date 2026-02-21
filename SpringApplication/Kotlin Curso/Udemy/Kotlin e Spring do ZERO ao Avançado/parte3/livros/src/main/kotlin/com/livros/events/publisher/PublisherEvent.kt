package com.livros.events.publisher

import com.livros.events.AuditEvent
import org.springframework.context.ApplicationEventPublisher

//Publicador Generico para auditar eventos.
abstract class PublisherEvent<T: AuditEvent<*>>(protected val publisher: ApplicationEventPublisher) {
    abstract fun publish(event: T)
}