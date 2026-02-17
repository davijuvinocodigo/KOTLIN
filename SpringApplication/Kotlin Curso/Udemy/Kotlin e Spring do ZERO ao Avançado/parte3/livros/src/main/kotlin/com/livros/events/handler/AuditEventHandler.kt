package com.livros.events.handler

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import com.livros.events.AuditEvent

abstract class AuditEventHandler {

    @Async
    @EventListener
    fun handleEvent(auditEvent: AuditEvent<*>) {
        try {
            onEvent(auditEvent)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    protected abstract fun onEvent(auditEvent: AuditEvent<*>)
}