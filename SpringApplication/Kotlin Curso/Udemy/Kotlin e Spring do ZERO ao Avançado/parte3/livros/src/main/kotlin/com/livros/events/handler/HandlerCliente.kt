package com.livros.events.handler

import com.livros.events.AuditEventCliente
import org.springframework.stereotype.Component

@Component
class EventClienteHandler: HandleEvent<AuditEventCliente>() {
        override fun process(event: AuditEventCliente) {

    }
}