package springboot_event

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

// Classe Pai Genérica
abstract class Publicador<T : Evento<*>>(
    protected val publisher: ApplicationEventPublisher
) {
    abstract fun publicar(evento: T)
}

// Publicador Síncrono (Genérico)
@Component
class PublicadorSincrono<T : Evento<*>>(
    publisher: ApplicationEventPublisher
) : Publicador<T>(publisher) {
    override fun publicar(evento: T) {
        println("📢 [Síncrono] Publicando evento: ${evento.tipo}")
        publisher.publishEvent(evento)
    }
}

// Publicador Assíncrono (Genérico)
@Component
class PublicadorAssincrono<T : Evento<*>>(
    publisher: ApplicationEventPublisher
) : Publicador<T>(publisher) {
    override fun publicar(evento: T) {
        Thread {
            Thread.sleep(1000)
            println("🔄 [Assíncrono] Publicando evento: ${evento.tipo}")
            publisher.publishEvent(evento)
        }.start()
    }
}