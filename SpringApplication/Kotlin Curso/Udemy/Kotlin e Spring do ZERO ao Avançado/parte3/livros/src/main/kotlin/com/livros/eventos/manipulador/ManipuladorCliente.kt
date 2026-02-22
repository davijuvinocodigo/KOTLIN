package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaCliente
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ManipuladorCliente : ManipuladorEvento<AuditoriaCliente>() {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun processar(evento: AuditoriaCliente) {
        with(evento.dados) {
            logger.info("Cliente processado - id: {}, nome: {}, email: {}, status: {}", id, nome, email, status)
        }
    }
}