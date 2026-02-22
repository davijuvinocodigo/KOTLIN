package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.ApplicationEventPublisher

//Publicador Generico para auditar eventos.
abstract class PublisherEvent<T: AuditoriaEvento<*>>(protected val publisher: ApplicationEventPublisher) {
    abstract fun publish(event: T)
}