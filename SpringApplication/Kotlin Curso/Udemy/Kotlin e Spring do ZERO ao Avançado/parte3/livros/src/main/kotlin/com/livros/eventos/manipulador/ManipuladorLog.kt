package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaEvento
import org.springframework.stereotype.Component

@Component
class ManipuladorLog : ManipuladorEvento<AuditoriaEvento<*>>() {
    override fun processar(evento: AuditoriaEvento<*>) {
        println("📝 LOG [${evento.dataHora}] - ${evento.tipo}: ${evento.id}")
    }
}