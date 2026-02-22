package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaEvento
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ManipuladorLog : ManipuladorEvento<AuditoriaEvento<*>>() {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun processar(evento: AuditoriaEvento<*>) {
        logger.info("LOG [{}] - {}: {}", evento.dataHora, evento.tipo, evento.id)
    }
}