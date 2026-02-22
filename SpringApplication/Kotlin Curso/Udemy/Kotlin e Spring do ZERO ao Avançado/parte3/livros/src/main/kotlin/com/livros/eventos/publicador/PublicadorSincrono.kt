package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class PublicadorSincrono<T : AuditoriaEvento<*>>(
    publicador: ApplicationEventPublisher
) : PublicadorEvento<T>(publicador) {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun publicar(evento: T) {
        logger.info("[Síncrono] Publicando evento: {}", evento.tipo)
        publicador.publishEvent(evento)
    }
}