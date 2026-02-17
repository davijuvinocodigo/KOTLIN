package com.livros.events.handler

import com.livros.events.AuditEvent

class AuditEventNfeHandler : AuditEventHandler() {
    override fun onEvent(auditEvent: AuditEvent<*>) {
        println("Gerando NFE")
        TODO("Not yet implemented")
    }
}