package com.livros.eventos.publicador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class PublicadorAssincrono<T : AuditoriaEvento<*>>(
    publicador: ApplicationEventPublisher
) : PublicadorEvento<T>(publicador) {
    override fun publicar(evento: T) {
        Thread {
            Thread.sleep(1000)
            println("🔄 [Assíncrono] Publicando evento: ${evento.tipo}")
            publicador.publishEvent(evento)
        }.start()
    }
}