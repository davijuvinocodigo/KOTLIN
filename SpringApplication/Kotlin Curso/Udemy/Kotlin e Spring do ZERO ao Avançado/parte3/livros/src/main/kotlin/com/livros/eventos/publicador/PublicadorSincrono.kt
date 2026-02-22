package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class PublicadorSincrono<T : AuditoriaEvento<*>>(
    publicador: ApplicationEventPublisher
) : PublicadorEvento<T>(publicador) {
    override fun publicar(evento: T) {
        println("📢 [Síncrono] Publicando evento: ${evento.tipo}")
        publicador.publishEvent(evento)
    }
}