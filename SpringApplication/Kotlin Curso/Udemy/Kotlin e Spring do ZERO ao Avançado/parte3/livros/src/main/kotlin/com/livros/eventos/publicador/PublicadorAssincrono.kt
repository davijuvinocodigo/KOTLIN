package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class PublicadorAssincrono<T : AuditoriaEvento<*>>(
    publicador: ApplicationEventPublisher
) : PublicadorEvento<T>(publicador) {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun publicar(evento: T) {
        Thread {
            try {
                Thread.sleep(1000)
                logger.info("[Assíncrono] Publicando evento: {}", evento.tipo)
                publicador.publishEvent(evento)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                logger.warn("Thread de publicação assíncrona interrompida", e)
            }
        }.apply { isDaemon = true }.start()
    }
}