package springboot_event.events.hadler

import springboot_event.events.AuditEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async

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