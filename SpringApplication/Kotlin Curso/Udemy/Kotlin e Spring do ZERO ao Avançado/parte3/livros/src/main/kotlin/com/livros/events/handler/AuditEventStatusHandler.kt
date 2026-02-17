package com.livros.events.handler

import com.livros.events.AuditEvent

class AuditEventStatusHandler : AuditEventHandler() {
    override fun onEvent(auditEvent: AuditEvent<*>) {
        println("Atualizando status dos livros")
        TODO("Not yet implemented")
    }
}