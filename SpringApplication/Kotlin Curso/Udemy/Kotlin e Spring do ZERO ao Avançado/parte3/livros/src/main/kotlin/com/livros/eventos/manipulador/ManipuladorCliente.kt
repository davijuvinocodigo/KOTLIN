package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaCliente
import org.springframework.stereotype.Component

@Component
class HandlerCliente: ManipuladorEvento<AuditoriaCliente>() {
        override fun process(event: AuditoriaCliente) {
            with(event.data) {
                println("🛒 Compra processada:")
                println("   ID: $id")
                println("   Cliente: $nome")
                println("   Email: $email ")
                println("   Status: $status")
            }
    }
}