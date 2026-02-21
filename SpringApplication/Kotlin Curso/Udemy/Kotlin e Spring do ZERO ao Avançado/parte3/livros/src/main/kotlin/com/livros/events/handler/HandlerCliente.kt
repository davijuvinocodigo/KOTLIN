package com.livros.events.handler

import com.livros.events.AuditCliente
import org.springframework.stereotype.Component

@Component
class HandlerCliente: HandlerEvent<AuditCliente>() {
        override fun process(event: AuditCliente) {
            with(event.data) {
                println("🛒 Compra processada:")
                println("   ID: $id")
                println("   Cliente: $nome")
                println("   Email: $email ")
                println("   Status: $status")
            }
    }
}