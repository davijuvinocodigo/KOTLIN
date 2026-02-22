package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaEvento
import org.springframework.context.event.EventListener

abstract class ManipuladorEvento<T : AuditoriaEvento<*>> {
    abstract fun processar(evento: T)

    @EventListener
    fun manipularEvento(evento: T) {
        println("👂 ${this.javaClass.simpleName} processando: ${evento.tipo}")
        processar(evento)
    }
}