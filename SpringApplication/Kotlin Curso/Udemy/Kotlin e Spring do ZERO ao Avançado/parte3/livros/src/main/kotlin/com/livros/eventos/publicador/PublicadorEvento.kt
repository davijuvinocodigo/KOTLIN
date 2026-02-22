package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.ApplicationEventPublisher

abstract class PublicadorEvento<T : AuditoriaEvento<*>>(protected val publicador: ApplicationEventPublisher) {
    abstract fun publicar(evento: T)
}