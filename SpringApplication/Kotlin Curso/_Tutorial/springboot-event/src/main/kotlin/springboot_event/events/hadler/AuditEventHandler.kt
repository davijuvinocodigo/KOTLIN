package springboot_event.events.hadler

import springboot_event.events.AuditEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import tools.jackson.databind.ObjectMapper

@Component
class AuditEventHandler {

    @Async
    @EventListener
    fun handleEvent(auditEvent: AuditEvent<*>) {
        try {
            val data = ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(auditEvent)
            println("Json Data : $data")
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}