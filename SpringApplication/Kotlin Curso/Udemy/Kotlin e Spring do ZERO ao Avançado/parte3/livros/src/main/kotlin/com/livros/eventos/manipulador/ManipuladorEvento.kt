package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaEvento
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener

abstract class ManipuladorEvento<T : AuditoriaEvento<*>> {
    abstract fun processar(evento: T)

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener
    fun manipularEvento(evento: T) {
        logger.info("{} processando: {}", this.javaClass.simpleName, evento.tipo)
        processar(evento)
    }
}