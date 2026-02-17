package springboot_event.events.hadler

import org.springframework.stereotype.Component
import springboot_event.events.AuditEvent
import com.fasterxml.jackson.databind.ObjectMapper

@Component
class AuditEventLoggingHandler : AuditEventHandler() {

    override fun onEvent(auditEvent: AuditEvent<*>) {
        val data = ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(auditEvent)
        println("Json Data : $data")
    }
}
