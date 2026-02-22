package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaCliente
import org.springframework.stereotype.Component

@Component
class ManipuladorCliente : ManipuladorEvento<AuditoriaCliente>() {
    override fun processar(evento: AuditoriaCliente) {
        with(evento.dados) {
            println("👤 Cliente processado:")
            println("   ID: $id")
            println("   Nome: $nome")
            println("   Email: $email")
            println("   Status: $status")
        }
    }
}